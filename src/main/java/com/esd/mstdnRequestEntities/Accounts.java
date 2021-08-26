package com.esd.mstdnRequestEntities;

public class Accounts extends RequestEntity {
    public String reason = "";
    public String username;
    public String email;
    public String password;
    public boolean agreement;
    public String locale;

    public Accounts() {}

    public Accounts(String username, String password, String email, boolean agreement, String locale) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.agreement = agreement;
        this.locale = locale;
    }

    @Override
    public String toString() {
        return toJsonString();
    }
}
