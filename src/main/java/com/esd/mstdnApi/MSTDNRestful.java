package com.esd.mstdnApi;

import com.esd.ApiPlayground;

/**
 * This class performs actual API requests.
 */
public class MSTDNRestful {
    private MSTDNRestfulRegister register = null;
    private RequestBackend requestBackend = null;
    private ResponseCallback responseCallback = null;

    /**
     * Constructor
     * @param register, MSTDNRestfulRegister instance that contains request context description
     * @param backendClass, String, to invoke a RequestBackend instance
     */
    public MSTDNRestful(MSTDNRestfulRegister register, String backendClass) {
        this.register = register;
        this.requestBackend = RequestBackend.getBackend(backendClass);
    }

    public MSTDNRestful(String backendClass) {
        this.requestBackend = RequestBackend.getBackend(backendClass);
    }

    /**
     * register setter
     * @param register, MSTDNRestfulRegister instance that contains request context description
     */
    public void setRegister(MSTDNRestfulRegister register) {
        this.register = register;
    }

    /**
     * callbackClass setter
     * @param callbackClass, String, fully qualified class name, this class must be a subclass of ResponseCallback
     */
    public void setResponseCallback(String callbackClass, ApiPlayground.ObservableResponse observableResponse) {
        this.responseCallback = ResponseCallback.getCallback(callbackClass);
        if (observableResponse != null && this.responseCallback != null) {
            {
                this.responseCallback.setObservableResponse(observableResponse);
            }
        }
    }

    public MSTDNRestfulRegister getRegister() {
        return register;
    }

    public RequestBackend getRequestBackend() {
        return requestBackend;
    }

    /**
     * call RequestBackend class's "request" method
     */
    public void performRequest() {
        requestBackend.request(register, responseCallback);
    }

    public void finishRequest() {
        requestBackend.teardown();
    }

    public boolean isFinished() {
        return requestBackend.isTearedDown();
    }
}
