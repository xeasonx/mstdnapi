package com.esd.mstdnResponseEntities;

public class Preferences extends Entity {
    public Preferences(String jsonString) {
        super(jsonString);
    }

    String postingDefaultVisibility;
    boolean postingDefaultSensitive;
    String postingDefaultLanguage;
    String readingExpandMedia;
    boolean readingExpandSpoilers;
}
