package com.esd.mstdnEntities;

public class ReportAdmin {
    String id;
    String action_taken;
    String comment;
    String created_at;
    String updated_at;
    Account account;
    Account target_account;
    Account assigned_account;
    String action_taken_by_account;
    Status[] statuses;
}
