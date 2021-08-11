package com.esd.mstdnResponseEntities;

public class PushSubscription extends Entity {
    public PushSubscription(String jsonString) {
        super(jsonString);
    }

    String id;
    String endpoint;
    String server_key;
    Alerts alerts;

    public static class Alerts {
        boolean follow;
        boolean favourite;
        boolean mention;
        boolean reblog;
        boolean poll;
    }
}
