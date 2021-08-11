package com.esd.mstdnResponseEntities;

public class Field extends Entity {
    public Field(String jsonString) {
        super(jsonString);
    }

    String name;
    String value;
    String verified_at;
}
