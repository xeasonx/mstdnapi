package com.esd.mstdnResponseEntities;

public class FeaturedTag extends Entity {
    public FeaturedTag(String jsonString) {
        super(jsonString);
    }

    String id;
    String name;
    String url;
    int statuses_count;
    String last_status_at;
}
