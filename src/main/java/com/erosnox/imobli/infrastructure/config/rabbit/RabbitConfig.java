package com.erosnox.imobli.infrastructure.config.rabbit;

import com.erosnox.imobli.core.communication.application.enums.Publishers;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Value("${spring.rabbitmq.template.exchange}")
    private String EXCHANGE;

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Queue otpQueue() {
        return new Queue(Publishers.OTP.getQueueName(), true);
    }

    @Bean
    public Binding otpBinding(Queue notificationQueue, DirectExchange exchange) {
        return BindingBuilder.bind(notificationQueue)
                .to(exchange)
                .with(Publishers.OTP.getRoutingKey());
    }
}
