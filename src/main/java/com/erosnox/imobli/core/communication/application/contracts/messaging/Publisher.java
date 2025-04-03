package com.erosnox.imobli.core.communication.application.contracts.messaging;

public interface Publisher<T> {
    void publish(T message);
}
