package com.esd.mstdnResponseEntities;

public class Tag extends Entity {
    public Tag(String jsonString) {
        super(jsonString);
    }

    String name;
    String url;
    History[] history;
}
