package com.esd.mstdnResponseEntities;

public class Marker extends Entity {
    public Marker(String jsonString) {
        super(jsonString);
    }

    MarkerNote home;
    MarkerNote notifications;

    public static class MarkerNote {
        String last_read_id;
        int version;
        String updated_at;
    }
}
