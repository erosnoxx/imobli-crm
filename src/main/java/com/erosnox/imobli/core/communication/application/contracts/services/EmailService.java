package com.erosnox.imobli.core.communication.application.contracts.services;

public interface EmailService {
    void sendEmail(String to, String subject, String body);
}
