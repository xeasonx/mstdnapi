package com.esd.mstdnResponseEntities;

public class ScheduledStatus extends Entity {
    public ScheduledStatus(String jsonString) {
        super(jsonString);
    }

    String id;
    String scheduled_at;
    Status params;
    Attachment[] media_attachments;
}
