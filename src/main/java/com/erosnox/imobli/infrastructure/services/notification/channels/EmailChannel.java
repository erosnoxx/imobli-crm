package com.erosnox.imobli.infrastructure.services.notification.channels;

import com.erosnox.imobli.core.communication.application.contracts.notification.NotificationChannel;
import com.erosnox.imobli.core.communication.application.contracts.services.EmailService;
import com.erosnox.imobli.core.communication.domain.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailChannel implements NotificationChannel {
    @Autowired
    private EmailService emailService;

    @Override
    public void sendNotification(Notification notification) {
        emailService.sendEmail(
                notification.getRecipient(),
                notification.getSubject(),
                notification.getBody());
    }
}
