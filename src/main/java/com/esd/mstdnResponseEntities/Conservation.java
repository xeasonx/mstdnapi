package com.esd.mstdnResponseEntities;

public class Conservation extends Entity {
    public Conservation(String jsonString) {
        super(jsonString);
    }

    String id;
    Account[] accounts;
    boolean unread;
    Status last_status;
}
