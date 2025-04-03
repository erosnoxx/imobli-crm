package com.erosnox.imobli.core.auth.application.usecases;

import com.erosnox.imobli.core.auth.application.contracts.services.LoginService;
import com.erosnox.imobli.core.auth.application.contracts.usecases.LoginUseCase;
import com.erosnox.imobli.core.auth.domain.models.request.LoginRequest;
import com.erosnox.imobli.core.auth.domain.models.response.LoginResponse;

public class LoginUseCaseImpl implements LoginUseCase {
    private final LoginService loginService;

    public LoginUseCaseImpl(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public LoginResponse execute(LoginRequest request) {
        return loginService.login(request);
    }
}
