package com.esd.mstdnRequestEntities;

public class OauthAuthorize extends RequestEntity {
    public String force_login;
    public String response_type = "code";
    public String client_id;
    public String redirect_uri = "urn:ietf:wg:oauth:2.0:oob";
    public String scope;

    public OauthAuthorize() {}

    public OauthAuthorize(String client_id) {
        this.client_id = client_id;
    }

    public OauthAuthorize(String response_type, String client_id, String redirect_uri) {
        this.response_type = response_type;
        this.client_id = client_id;
        this.redirect_uri = redirect_uri;
    }

    @Override
    public String toString() {
        return toQuery();
    }
}
