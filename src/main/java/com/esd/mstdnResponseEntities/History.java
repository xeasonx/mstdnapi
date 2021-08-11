package com.esd.mstdnResponseEntities;

public class History extends Entity {
    public History(String jsonString) {
        super(jsonString);
    }

    String day;
    String uses;
    String accounts;
}
