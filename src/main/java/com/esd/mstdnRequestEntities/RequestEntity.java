package com.esd.mstdnRequestEntities;

import com.google.gson.Gson;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * This is the base class for processing request parameters.
 * Request parameters may be any type of;
 * - path
 * - query
 * - body
 * - header
 * This class provides some useful methods that formats these parameters
 */
public abstract class RequestEntity {
    public abstract String toString();

    public String toPath() {
        try {
            return concatParams("/", true);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toQuery() {
        try {
            return concatParams("&", false);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String toJsonString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public HashMap<String, String> getFields() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        Field[] fields = this.getClass().getFields();
        try {
            for (Field field : fields) {
                String key = field.getName();
                Object value = field.get(this);
                if (value != null) {
                    String v = value.toString();
                    if (!v.isEmpty()) {
                        hashMap.put(key, v);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            return null;
        }
        return hashMap;
    }

    public String concatParams(String delimiter, boolean valueOnly) throws Exception {
        ArrayList<String> queryArray = new ArrayList<>();
        Field[] fields = this.getClass().getFields();
        if (valueOnly) {
            for (Field field : fields) {
                Object value = field.get(this);
                if (value != null) {
                    String v = value.toString();
                    if (!v.isEmpty()) {
                        queryArray.add(v);
                    }
                }
            }
        } else {
            for (Field field : fields) {
                String key = field.getName();
                Object value = field.get(this);
                if (value != null) {
                    String v = value.toString();
                    if (!v.isEmpty()) {
                        queryArray.add(key + "=" + v);
                    }
                }
            }
        }

        return String.join(delimiter, queryArray);
    }
}
