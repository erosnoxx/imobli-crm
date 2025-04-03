package com.erosnox.imobli.core.communication.application.contracts.notification;

import com.erosnox.imobli.core.communication.domain.Notification;

public interface NotificationChannel {
    void sendNotification(Notification notification);
}
