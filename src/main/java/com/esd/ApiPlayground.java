package com.esd;

import com.esd.mstdnApi.*;
import com.esd.mstdnRequestEntities.Accounts;
import com.esd.mstdnRequestEntities.Apps;
import com.esd.mstdnRequestEntities.OauthToken;
import com.esd.mstdnResponseEntities.Application;
import com.esd.mstdnResponseEntities.Token;
import com.google.gson.Gson;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.HashMap;
import java.util.Properties;

public class ApiPlayground {
    private Properties appProperties;
    private HashMap<String, MSTDNRestfulRegister> registerMap;
    private MSTDNRestful mstdnRestful;
    private String apiPrivateBase;
    private String apiPublicBase;

    public ApiPlayground() {}

    public ApiPlayground(Properties appProperties, HashMap<String, MSTDNRestfulRegister> registerMap, MSTDNRestful mstdnRestful) {
        this.appProperties = appProperties;
        this.registerMap = registerMap;
        this.mstdnRestful = mstdnRestful;
        setApiBase();
    }

    private void setApiBase() {
        if (this.appProperties != null) {
            String protocol = this.appProperties.getProperty("mstdn.protocol");
            String host = this.appProperties.getProperty("mstdn.host");
            int port = Integer.parseInt(this.appProperties.getProperty("mstdn.port"));
            String root = this.appProperties.getProperty("mstdn.root");
            if (port == 80) {
                this.apiPrivateBase = String.format("%s://%s", protocol, host);
                this.apiPublicBase = String.format("%s://%s/%s", protocol, host, root);
            } else {
                this.apiPrivateBase = String.format("%s://%s:%d", protocol, host, port);
                this.apiPublicBase = String.format("%s://%s:%d/%s", protocol, host, port, root);
            }
        }
    }

    public void setAppProperties(Properties appProperties) {
        this.appProperties = appProperties;
        setApiBase();
    }

    public void setMstdnRestful(MSTDNRestful mstdnRestful) {
        this.mstdnRestful = mstdnRestful;
    }

    public void setRegisterMap(HashMap<String, MSTDNRestfulRegister> registerMap) {
        this.registerMap = registerMap;
    }

    /**
     * Register a new user account needs a series of requests to be performed in order
     * 1. create an application by requesting API /apps, store 'client_id' and 'client_secret'
     * 2. get app token by requesting API /oauth/token, provide stored 'client_id' and 'client_secret'
     * 3. verify app credentials
     * 4. register new account by requesting API /accounts, provide app token in headers
     * 5. verify account credentials
     */
    public String registerAccount(String username, String password, String email, String locale, boolean agreement) {
        MSTDNRestfulRegister register;
        ObservableResponse observable = new ObservableResponse();
        ResponseObserver observer = new ResponseObserver(this.apiPrivateBase, this.apiPublicBase, this.registerMap, this.mstdnRestful);
        observer.setUser(username, password, email, locale, agreement);
        observable.addPropertyChangeListener(observer);

        // API /apps, fetch 'client_id' and 'client_secret'
        register = registerMap.get("apps");
        Apps requestBody = new Apps("mstdnpublic");
        requestBody.scopes = "read write follow push";
        register.path = apiPublicBase + "/" + register.path;
        register.body = requestBody;
        mstdnRestful.setRegister(register);
        mstdnRestful.setResponseCallback("com.esd.mstdnCallbacks.ObservableCallback", observable);
        mstdnRestful.performRequest();
        while (true) {
            if (mstdnRestful.isFinished()) {
                break;
            }
        }
        observable.removePropertyChangeListener(observer);
        return observer.getResponseBody();
    }

    public static class ObservableResponse {
        private String responseBody;
        private PropertyChangeSupport support;

        public ObservableResponse() {
            this.support = new PropertyChangeSupport(this);
        }

        public void setResponseBody(String responseBy, String responseBody) {
            support.firePropertyChange(responseBy, this.responseBody, responseBody);
            this.responseBody = responseBody;
        }

        public String getResponseBody() {
            return responseBody;
        }

        public void addPropertyChangeListener(PropertyChangeListener listener) {
            support.addPropertyChangeListener(listener);
        }

        public void removePropertyChangeListener(PropertyChangeListener listener) {
            support.removePropertyChangeListener(listener);
        }
    }

    public static class ResponseObserver implements PropertyChangeListener {
        private String responseBody;
        private String apiPrivateBase;
        private String apiPublicBase;
        private HashMap<String, MSTDNRestfulRegister> registerMap;
        private MSTDNRestful mstdnRestful;
        private String username;
        private String password;
        private String email;
        private String locale;
        private boolean agreement;

        public ResponseObserver(String apiPrivateBase, String apiPublicBase, HashMap<String, MSTDNRestfulRegister> registerMap, MSTDNRestful mstdnRestful) {
            this.apiPrivateBase = apiPrivateBase;
            this.apiPublicBase = apiPublicBase;
            this.registerMap = registerMap;
            this.mstdnRestful = mstdnRestful;
        }

        public void setResponseBody(String responseBody) {
            this.responseBody = responseBody;
        }

        public String getResponseBody() {
            return this.responseBody;
        }

        public void setUser(String username, String password, String email, String locale, boolean agreement){
            this.username = username;
            this.password = password;
            this.email = email;
            this.locale = locale;
            this.agreement = agreement;
        }

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            Gson gson = new Gson();
            MSTDNRestfulRegister register;
            responseBody = evt.getNewValue().toString();
            System.out.println(responseBody);
            if (evt.getPropertyName().equals("apps")) {
                // API /oauth/token, fetch 'access_token'
                Application application = gson.fromJson(responseBody, Application.class);
                register = registerMap.get("oauthToken");
                register.path = apiPrivateBase + "/" + register.path;
                OauthToken requestBody = new OauthToken(application.client_id, application.client_secret);
                requestBody.scope = "read write follow push";
                register.body = requestBody;
                mstdnRestful.setRegister(register);
                mstdnRestful.performRequest();
            } else if (evt.getPropertyName().equals("oauthToken")) {
                // API /accounts, register
                Token token = gson.fromJson(responseBody, Token.class);
                register = registerMap.get("accounts");
                register.path = apiPublicBase + "/" + register.path;
                Accounts requestBody = new Accounts(username, password, email, agreement, locale);
                register.body = requestBody;
                register.headers.put("Authorization", "Bearer " + token.access_token);
                mstdnRestful.setRegister(register);
                mstdnRestful.performRequest();
            } else if (evt.getPropertyName().equals("accounts")) {
                mstdnRestful.finishRequest();
            }
        }
    }
}
