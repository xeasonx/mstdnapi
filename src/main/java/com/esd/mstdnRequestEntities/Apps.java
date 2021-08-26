package com.esd.mstdnRequestEntities;

public class Apps extends RequestEntity{
    public String client_name;
    public String redirect_uris = "urn:ietf:wg:oauth:2.0:oob";
    public String scopes;
    public String website;

    public Apps() {}

    public Apps(String client_name) {
        this.client_name = client_name;
    }

    public Apps(String client_name, String redirect_uris) {
        this.client_name = client_name;
        this.redirect_uris = redirect_uris;
    }

    @Override
    public String toString() {
        return toQuery();
    }
}
