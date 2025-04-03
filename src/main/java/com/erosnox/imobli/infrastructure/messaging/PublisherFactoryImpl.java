package com.erosnox.imobli.infrastructure.messaging;

import com.erosnox.imobli.core.communication.application.contracts.messaging.Publisher;
import com.erosnox.imobli.core.communication.application.contracts.messaging.PublisherFactory;
import com.erosnox.imobli.core.communication.application.enums.Publishers;
import com.erosnox.imobli.infrastructure.messaging.publishers.OtpQueuePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherFactoryImpl implements PublisherFactory {
    @Autowired
    private OtpQueuePublisher otpQueuePublisher;

    @Override
    public Publisher getPublisher(Publishers type) {
        switch (type) {
            case OTP:
                return otpQueuePublisher;
            default:
                throw new IllegalStateException("Unsupported publisher type: " + type);
        }
    }
}
