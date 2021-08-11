package com.esd.mstdnResponseEntities;

public class AnnouncementReaction extends Entity {
    public AnnouncementReaction(String jsonString) {
        super(jsonString);
    }

    String name;
    int count;
    boolean me;
    String url;
    String static_url;

}
