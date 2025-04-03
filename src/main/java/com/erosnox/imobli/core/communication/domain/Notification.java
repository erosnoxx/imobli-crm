package com.erosnox.imobli.core.communication.domain;

import com.erosnox.imobli.core.communication.application.enums.NotificationType;

public class Notification {
    private String recipient;
    private String subject;
    private String body;
    private NotificationType type;

    public Notification(
            String recipient,
            String subject,
            String body,
            NotificationType type) {
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
        this.type = type;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public NotificationType getType() {
        return type;
    }
}
