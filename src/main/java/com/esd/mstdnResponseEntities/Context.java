package com.esd.mstdnResponseEntities;

public class Context extends Entity {
    public Context(String jsonString) {
        super(jsonString);
    }

    Status[] ancestors;
    Status[] descendants;
}
