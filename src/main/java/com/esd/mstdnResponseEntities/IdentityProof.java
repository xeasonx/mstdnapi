package com.esd.mstdnResponseEntities;

public class IdentityProof extends Entity {
    public IdentityProof(String jsonString) {
        super(jsonString);
    }

    String provider;
    String provider_username;
    String updated_at;
    String proof_url;
    String profile_url;
}
