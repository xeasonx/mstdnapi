package com.esd.mstdnResponseEntities;

public class Source extends Entity {
    public Source(String jsonString) {
        super(jsonString);
    }

    String note;
    Field[] fields;
    String privacy;
    boolean sensitive;
    String language;
    int follow_requests_count;
}
