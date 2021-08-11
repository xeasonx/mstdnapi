package com.esd.mstdnResponseEntities;

public class AccountAdmin extends Entity {
    public AccountAdmin(String jsonString) {
        super(jsonString);
    }

    String id;
    String username;
    String domain;
    String created_at;
    String email;
    String ip;
    String locale;
    String invite_request;
    String role;
    boolean confirmed;
    boolean approved;
    boolean disabled;
    boolean silenced;
    boolean suspended;
    Account account;
    String created_by_application_id;
    String invited_by_account_id;
}
