package com.esd.mstdnResponseEntities;

public class Filter extends Entity {
    public Filter(String jsonString) {
        super(jsonString);
    }

    String id;
    String phrase;
    String[] context;
    String expires_at;
    boolean irreversible;
    boolean whole_word;

}
