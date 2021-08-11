package com.esd.mstdnResponseEntities;

public class Poll extends Entity {
    public Poll(String jsonString) {
        super(jsonString);
    }

    String id;
    String expires_at;
    boolean expired;
    boolean multiple;
    int votes_count;
    int voters_count;
    boolean voted;
    int[] own_votes;
    PollOption options;
    Emoji[] emojis;

    public static class PollOption {
        String title;
        int votes_count;
    }
}
