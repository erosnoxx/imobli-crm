package com.erosnox.imobli.core.communication.application.contracts.messaging;

import com.erosnox.imobli.core.communication.application.enums.Publishers;

public interface PublisherService {
    void setPublisher(Publishers type);
    <T> void publish(T message);
}
