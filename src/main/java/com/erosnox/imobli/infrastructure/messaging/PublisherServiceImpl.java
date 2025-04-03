package com.erosnox.imobli.infrastructure.messaging;

import com.erosnox.imobli.core.communication.application.contracts.messaging.Publisher;
import com.erosnox.imobli.core.communication.application.contracts.messaging.PublisherFactory;
import com.erosnox.imobli.core.communication.application.contracts.messaging.PublisherService;
import com.erosnox.imobli.core.communication.application.enums.Publishers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherServiceImpl implements PublisherService {
    private Publisher publisher;
    @Autowired
    private PublisherFactory publisherFactory;

    public PublisherServiceImpl() {
        publisher = null;
    }

    @Override
    public void setPublisher(Publishers type) {
        publisher = publisherFactory.getPublisher(type);
        this.publisher = publisher;
    }

    @Override
    public <T> void publish(T message) {
        if (publisher == null) {
            throw new RuntimeException("Publisher not set");
        }

        publisher.publish(message);
    }
}
