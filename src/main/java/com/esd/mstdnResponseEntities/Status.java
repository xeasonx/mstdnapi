package com.esd.mstdnResponseEntities;

public class Status extends Entity {
    public Status(String jsonString) {
        super(jsonString);
    }

    String id;
    String uri;
    String created_at;
    Account account;
    String content;
    String visibility;
    boolean sensitive;
    String spoiler_text;
    Attachment[] media_attachments;
    Application application;
    Mention[] mentions;
    Tag[] tags;
    Emoji[] emojis;
    int reblogs_count;
    int favourites_count;
    int replies_count;
    String url;
    String in_reply_to_id;
    String in_reply_to_account_id;
    Status reblog;
    Poll poll;
    Card card;
    String language;
    String text;
    boolean favourited;
    boolean reblogged;
    boolean muted;
    boolean bookmarked;
    boolean pinned;
}
