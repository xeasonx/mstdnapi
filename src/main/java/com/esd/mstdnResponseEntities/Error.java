package com.esd.mstdnResponseEntities;

public class Error extends Entity {
    public Error(String jsonString) {
        super(jsonString);
    }

    String error;
    String error_description;
}
