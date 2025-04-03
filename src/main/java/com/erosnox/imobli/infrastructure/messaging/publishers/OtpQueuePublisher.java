package com.erosnox.imobli.infrastructure.messaging.publishers;

import com.erosnox.imobli.core.communication.application.contracts.messaging.Publisher;
import com.erosnox.imobli.core.communication.domain.Notification;
import com.google.gson.Gson;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OtpQueuePublisher implements Publisher<Notification> {
    private final AmqpTemplate amqpTemplate;

    @Value("${spring.rabbitmq.template.exchange}")
    private String exchange;
    private static final String routingKey = "otp";
    private final Gson gson = new Gson();

    public OtpQueuePublisher(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @Override
    public void publish(Notification message) {
        var json = gson.toJson(message);
        amqpTemplate.convertAndSend(exchange, routingKey, json);
    }
}
