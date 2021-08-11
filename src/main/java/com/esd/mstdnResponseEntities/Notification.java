package com.esd.mstdnResponseEntities;

public class Notification extends Entity {
    public Notification(String jsonString) {
        super(jsonString);
    }

    String id;
    String type;
    String created_at;
    Account account;
    Status status;
}
