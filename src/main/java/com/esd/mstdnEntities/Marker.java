package com.esd.mstdnEntities;

public class Marker {
    MarkerNote home;
    MarkerNote notifications;

    public static class MarkerNote {
        String last_read_id;
        int version;
        String updated_at;
    }
}
