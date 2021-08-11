package com.esd.mstdnResponseEntities;

public class Application extends Entity {
    public Application(String jsonString) {
        super(jsonString);
    }

    String name;
    String website;
    String vapid_key;
    String client_id;
    String client_secret;
}
