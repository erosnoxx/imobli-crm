package com.erosnox.imobli.core.communication.application.contracts.notification;

import com.erosnox.imobli.core.communication.application.enums.NotificationType;
import com.erosnox.imobli.core.communication.domain.Notification;

public interface NotificationService {
    void setChannel(NotificationType type);
    void sendNotification(Notification notification);
}
