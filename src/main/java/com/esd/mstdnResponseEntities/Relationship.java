package com.esd.mstdnResponseEntities;

public class Relationship extends Entity {
    public Relationship(String jsonString) {
        super(jsonString);
    }

    String id;
    boolean following;
    boolean showing_reblogs;
    boolean notifying;
    boolean followed_by;
    boolean blocking;
    boolean blocked_by;
    boolean muting;
    boolean muting_notifications;
    boolean requested;
    boolean domain_blocking;
    boolean endorsed;
    String note;
}
