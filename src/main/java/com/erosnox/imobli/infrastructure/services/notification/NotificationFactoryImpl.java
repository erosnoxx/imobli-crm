package com.erosnox.imobli.infrastructure.services.notification;

import com.erosnox.imobli.core.communication.application.contracts.notification.NotificationChannel;
import com.erosnox.imobli.core.communication.application.contracts.notification.NotificationFactory;
import com.erosnox.imobli.core.communication.application.enums.NotificationType;
import com.erosnox.imobli.infrastructure.services.notification.channels.DiscordChannel;
import com.erosnox.imobli.infrastructure.services.notification.channels.EmailChannel;
import com.erosnox.imobli.infrastructure.services.notification.channels.SmsChannel;
import com.erosnox.imobli.infrastructure.services.notification.channels.WhatsappChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationFactoryImpl implements NotificationFactory {
    @Autowired
    private EmailChannel emailChannel;
    @Autowired
    private WhatsappChannel whatsappChannel;
    @Autowired
    private SmsChannel smsChannel;
    @Autowired
    private DiscordChannel discordChannel;

    @Override
    public NotificationChannel getChannel(NotificationType type) {
        switch (type) {
            case EMAIL:
                return emailChannel;
            case WHATSAPP:
                return whatsappChannel;
            case SMS:
                return smsChannel;
            case DISCORD:
                return discordChannel;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }
}
