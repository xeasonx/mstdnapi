package com.esd.mstdnEntities;

public class Announcement {
    String id;
    String text;
    boolean published;
    boolean all_day;
    String created_at;
    String updated_at;
    boolean read;
    AnnouncementReaction[] reactions;
    String scheduled_at;
    String starts_at;
    String ends_at;
}
