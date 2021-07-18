package com.esd.mstdnEntities;

public class Poll {
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
