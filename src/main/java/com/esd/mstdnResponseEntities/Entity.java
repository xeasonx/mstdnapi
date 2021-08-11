package com.esd.mstdnResponseEntities;

import com.google.gson.Gson;

/**
 * Base class of response body.
 * Since all mstdn API responses' bodies are JSON strings, this class provides a method which converts JSON strings
 * to objects. These objects should be super classes of Entity class, and contain all keys of the JSON strings as
 * their instance variables.
 * The conversion is accomplished by using GSON library.
 */
public abstract class Entity {
    public final String jsonString;

    public Entity(String jsonString) {
        this.jsonString = jsonString;
    }

    /**
     * Converts JSON string to concrete object of this type.
     * @return this
     */
    public Entity toEntity() {
        Gson gson = new Gson();
        return gson.fromJson(this.jsonString, this.getClass());
    }
}
