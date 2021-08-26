package com.esd.mstdnRequestEntities;

public class OauthToken extends RequestEntity{
    public String client_id;
    public String client_secret;
    public String redirect_uri = "urn:ietf:wg:oauth:2.0:oob";
    public String scope = "read";
    public String code;
    public String grant_type = "client_credentials";

    public OauthToken() {}

    public OauthToken(String client_id, String client_secret) {
        this.client_id = client_id;
        this.client_secret = client_secret;
    }

    @Override
    public String toString() {
        return toQuery();
    }
}
