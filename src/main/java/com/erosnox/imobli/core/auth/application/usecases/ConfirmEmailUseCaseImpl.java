package com.erosnox.imobli.core.auth.application.usecases;

import com.erosnox.imobli.core.auth.application.contracts.repositories.UserRepository;
import com.erosnox.imobli.core.auth.application.contracts.services.OtpCodeService;
import com.erosnox.imobli.core.auth.application.contracts.usecases.ConfirmEmailUseCase;


public class ConfirmEmailUseCaseImpl implements ConfirmEmailUseCase {
    private final UserRepository repository;
    private final OtpCodeService otpCodeService;

    public ConfirmEmailUseCaseImpl(UserRepository repository, OtpCodeService otpCodeService) {
        this.repository = repository;
        this.otpCodeService = otpCodeService;
    }


    @Override
    public void execute(String otpCode) {
        var otpDto = otpCodeService.validateOtpCode(otpCode);
        //
        repository.activateUser(otpDto.userId());
    }
}
