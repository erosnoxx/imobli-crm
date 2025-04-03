package com.erosnox.imobli.core.communication.application.contracts.notification;

import com.erosnox.imobli.core.communication.application.enums.NotificationType;

public interface NotificationFactory {
    NotificationChannel getChannel(NotificationType type);
}
