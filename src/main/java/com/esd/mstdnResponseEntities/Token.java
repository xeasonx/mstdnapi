package com.esd.mstdnResponseEntities;

public class Token extends Entity {
    public Token(String jsonString) {
        super(jsonString);
    }

    String access_token;
    String token_type;
    String scope;
    int created_at;
}
