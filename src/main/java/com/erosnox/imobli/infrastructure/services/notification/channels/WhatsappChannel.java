package com.erosnox.imobli.infrastructure.services.notification.channels;

import com.erosnox.imobli.core.communication.application.contracts.notification.NotificationChannel;
import com.erosnox.imobli.core.communication.domain.Notification;
import org.springframework.stereotype.Service;

@Service
public class WhatsappChannel implements NotificationChannel {
    @Override
    public void sendNotification(Notification notification) {
        System.out.println("WhatsappChannel sendNotification");
    }
}
