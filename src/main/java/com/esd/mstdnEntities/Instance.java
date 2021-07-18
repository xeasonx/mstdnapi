package com.esd.mstdnEntities;

public class Instance {
    String uri;
    String title;
    String description;
    String short_description;
    String email;
    String version;
    String[] languages;
    boolean registrations;
    boolean approval_required;
    boolean invites_enabled;
    StreamingAPI urls;
    Stats stats;
    String thumbnail;
    Account contact_account;

    public static class StreamingAPI {
        String streaming_api;
    }

    public static class Stats {
        int user_count;
        int status_count;
        int domain_count;
    }
}
