package com.esd.mstdnEntities;

public class PushSubscription {
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
