package com.esd.mstdnResponseEntities;

public class Account extends Entity {
    public Account(String jsonString) {
        super(jsonString);
    }

    String id;
    String username;
    String acct;
    String display_name;
    boolean locked;
    boolean bot;
    String created_at;
    String note;
    String url;
    String avatar;
    String avatar_static;
    String header;
    String header_static;
    int followers_count;
    int following_count;
    int statuses_count;
    String last_status_at;
    boolean discoverable;
    Emoji[] emojis;
    Field[] fields;
    Account moved;
    boolean suspend;
    String mute_expires_at;
    Source source;
}
