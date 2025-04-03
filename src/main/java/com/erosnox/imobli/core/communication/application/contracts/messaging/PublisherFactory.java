package com.erosnox.imobli.core.communication.application.contracts.messaging;

import com.erosnox.imobli.core.communication.application.enums.Publishers;

public interface PublisherFactory {
    Publisher getPublisher(Publishers type);
}
