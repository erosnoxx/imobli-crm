package com.erosnox.imobli.infrastructure.messaging.listeners;

import com.erosnox.imobli.core.communication.application.contracts.messaging.Listener;
import com.erosnox.imobli.core.communication.application.contracts.notification.NotificationFactory;
import com.erosnox.imobli.core.communication.application.contracts.notification.NotificationService;
import com.erosnox.imobli.core.communication.application.enums.Publishers;
import com.erosnox.imobli.core.communication.domain.Notification;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OtpQueueListener implements Listener {
    @Autowired
    private NotificationService notificationService;
    private static final Gson gson = new Gson();

    @Override
    @RabbitListener(queues = "otpQueue")
    public void startListening(String message) {
        var notification = deserializeNotification(message);
        processNotification(notification);
    }

    private Notification deserializeNotification(String message) {
        return gson.fromJson(message, Notification.class);
    }

    private void processNotification(Notification notification) {
        notificationService.setChannel(notification.getType());
        notificationService.sendNotification(notification);
    }
}
