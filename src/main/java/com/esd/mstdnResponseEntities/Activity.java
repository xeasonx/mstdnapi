package com.esd.mstdnResponseEntities;

public class Activity extends Entity {
    public Activity(String jsonString) {
        super(jsonString);
    }

    String week;
    String statuses;
    String logins;
    String registrations;
}
