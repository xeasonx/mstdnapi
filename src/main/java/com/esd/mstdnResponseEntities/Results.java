package com.esd.mstdnResponseEntities;

public class Results extends Entity {
    public Results(String jsonString) {
        super(jsonString);
    }

    Account[] accounts;
    Status[] statuses;
    Tag[] hashtags;
}
