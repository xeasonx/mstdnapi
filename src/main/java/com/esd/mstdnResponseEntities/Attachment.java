package com.esd.mstdnResponseEntities;

public class Attachment extends Entity {
    public Attachment(String jsonString) {
        super(jsonString);
    }

    String id;
    String type;
    String url;
    String preview_url;
    String remote_url;
    String text_url;
    Meta meta;
    String description;
    String blurhash;
}
