package com.erosnox.imobli.infrastructure.services.notification;

import com.erosnox.imobli.core.communication.application.contracts.notification.NotificationChannel;
import com.erosnox.imobli.core.communication.application.contracts.notification.NotificationFactory;
import com.erosnox.imobli.core.communication.application.contracts.notification.NotificationService;
import com.erosnox.imobli.core.communication.application.enums.NotificationType;
import com.erosnox.imobli.core.communication.domain.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {
    private NotificationChannel channel;
    @Autowired
    private NotificationFactory notificationFactory;

    public NotificationServiceImpl() {
        this.channel = null;
    }

    @Override
    public void setChannel(NotificationType type) {
        var channel = notificationFactory.getChannel(type);
        this.channel = channel;
    }

    @Override
    public void sendNotification(Notification notification) {
        if (channel == null) {
            throw new RuntimeException("Notification channel not set");
        }

        channel.sendNotification(notification);
    }
}
