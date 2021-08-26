package com.esd.mstdnResponseEntities;

public class Application extends Entity {
    public Application(String jsonString) {
        super(jsonString);
    }

    public String id;
    public String name;
    public String website;
    public String redirect_uri;
    public String vapid_key;
    public String client_id;
    public String client_secret;
}
