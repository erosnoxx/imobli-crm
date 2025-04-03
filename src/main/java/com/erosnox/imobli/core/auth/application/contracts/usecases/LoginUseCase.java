package com.erosnox.imobli.core.auth.application.contracts.usecases;

import com.erosnox.imobli.core.auth.domain.models.request.LoginRequest;
import com.erosnox.imobli.core.auth.domain.models.response.LoginResponse;

public interface LoginUseCase {
    LoginResponse execute(LoginRequest request);
}
