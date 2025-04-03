package com.erosnox.imobli.core.communication.application.enums;

public enum Publishers {
    OTP("otp", "otpQueue"),
    NOTIFICATION("notification", "notificationQueue");

    private final String routingKey;
    private final String queueName;

    Publishers(String routingKey, String queueName) {
        this.routingKey = routingKey;
        this.queueName = queueName;
    }

    public String getRoutingKey() {
        return routingKey;
    }

    public String getQueueName() {
        return queueName;
    }
}
