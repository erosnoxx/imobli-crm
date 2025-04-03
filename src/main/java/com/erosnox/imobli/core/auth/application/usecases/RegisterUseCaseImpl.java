package com.erosnox.imobli.core.auth.application.usecases;

import com.erosnox.imobli.core.auth.application.contracts.repositories.UserRepository;
import com.erosnox.imobli.core.auth.application.contracts.services.OtpCodeService;
import com.erosnox.imobli.core.auth.application.contracts.usecases.RegisterUseCase;
import com.erosnox.imobli.core.auth.application.enums.Roles;
import com.erosnox.imobli.core.auth.application.mappers.UserMapper;
import com.erosnox.imobli.core.auth.domain.entities.User;
import com.erosnox.imobli.core.auth.domain.models.request.RegisterRequest;
import com.erosnox.imobli.core.auth.domain.models.response.RegisterResponse;
import com.erosnox.imobli.core.auth.domain.services.PasswordService;
import com.erosnox.imobli.core.communication.application.contracts.messaging.PublisherService;
import com.erosnox.imobli.core.communication.application.enums.NotificationType;
import com.erosnox.imobli.core.communication.domain.Notification;
import com.erosnox.imobli.core.communication.utils.EmailTemplateLoader;
import com.erosnox.imobli.core.shared.exceptions.ConflictException;

import java.util.Map;
import java.util.UUID;

public class RegisterUseCaseImpl implements RegisterUseCase {
    private final UserRepository userRepository;
    private final OtpCodeService otpCodeService;
    private final PublisherService publisherService;

    public RegisterUseCaseImpl(UserRepository userRepository, OtpCodeService otpCodeService, PublisherService publisherService) {
        this.userRepository = userRepository;
        this.otpCodeService = otpCodeService;
        this.publisherService = publisherService;
    }

    @Override
    public RegisterResponse execute(RegisterRequest request) {
        validateEmailAvailability(request.email());

        var user = createAndSaveUser(request);
        var otpCode = generateAndStoreOtp(user.getId());
        var emailBody = buildOtpEmail(otpCode);

        sendNotification(user.getEmail(), emailBody);

        return UserMapper.toResponse(user);
    }

    private void validateEmailAvailability(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new ConflictException("Email already exists");
        }
    }

    private User createAndSaveUser(RegisterRequest request) {
        var passwordHash = PasswordService.encode(request.password());
        var user = UserMapper.fromRequest(request.email(), passwordHash, Roles.MANAGER, false);
        return userRepository.save(user);
    }

    private String generateAndStoreOtp(UUID userId) {
        var otpCode = otpCodeService.generateOtpCode(6);
        otpCodeService.saveOtpCode(otpCode, userId);
        return otpCode;
    }

    private String buildOtpEmail(String otpCode) {
        var template = EmailTemplateLoader.loadTemplate("otpCodeEmail.html");
        var placeholders = Map.of(
                "IMAGE_LINK", "https://i.imgur.com/oov0zJI.png",
                "OTP_CODE", otpCode
        );
        return EmailTemplateLoader.processTemplate(template, placeholders);
    }

    private void sendNotification(String email, String body) {
        var notification = new Notification(
                email,
                "Imobli - Email Confirmation",
                body,
                NotificationType.EMAIL);
        publisherService.publish(notification);
    }
}
