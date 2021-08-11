package com.esd.mstdnResponseEntities;

public class Mention extends Entity {
    public Mention(String jsonString) {
        super(jsonString);
    }

    String id;
    String username;
    String url;
    String acct;
}
