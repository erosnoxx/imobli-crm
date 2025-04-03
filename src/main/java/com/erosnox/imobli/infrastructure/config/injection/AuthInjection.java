package com.erosnox.imobli.infrastructure.config.injection;

import com.erosnox.imobli.core.auth.application.contracts.repositories.UserRepository;
import com.erosnox.imobli.core.auth.application.contracts.services.LoginService;
import com.erosnox.imobli.core.auth.application.contracts.services.OtpCodeService;
import com.erosnox.imobli.core.auth.application.contracts.usecases.LoginUseCase;
import com.erosnox.imobli.core.auth.application.contracts.usecases.RegisterUseCase;
import com.erosnox.imobli.core.auth.application.usecases.LoginUseCaseImpl;
import com.erosnox.imobli.core.auth.application.usecases.RegisterUseCaseImpl;
import com.erosnox.imobli.core.communication.application.contracts.messaging.PublisherService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthInjection {
    @Bean
    public RegisterUseCase registerUseCase(
            UserRepository repository, OtpCodeService otpCodeService, PublisherService publisherService) {
        return new RegisterUseCaseImpl(repository, otpCodeService, publisherService);
    }

    @Bean
    public LoginUseCase loginUseCase(LoginService service) {
        return new LoginUseCaseImpl(service);
    }
}
