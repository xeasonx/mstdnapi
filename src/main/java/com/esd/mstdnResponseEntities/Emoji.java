package com.esd.mstdnResponseEntities;

public class Emoji extends Entity {
    public Emoji(String jsonString) {
        super(jsonString);
    }

    String shortcode;
    String url;
    String static_url;
    boolean visible_in_picker;
    String category;
}
