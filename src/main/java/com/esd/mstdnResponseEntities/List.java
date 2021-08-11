package com.esd.mstdnResponseEntities;

public class List extends Entity {
    public List(String jsonString) {
        super(jsonString);
    }

    String id;
    String title;
    String replies_policy;
}
