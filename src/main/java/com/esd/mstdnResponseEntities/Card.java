package com.esd.mstdnResponseEntities;

public class Card extends Entity {
    public Card(String jsonString) {
        super(jsonString);
    }

    String url;
    String title;
    String description;
    String type;
    String author_name;
    String author_url;
    String provider_name;
    String provider_url;
    String html;
    int width;
    int height;
    String image;
    String embed_url;
    String blurhash;
}
