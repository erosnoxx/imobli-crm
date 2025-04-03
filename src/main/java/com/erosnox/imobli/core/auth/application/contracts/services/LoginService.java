package com.erosnox.imobli.core.auth.application.contracts.services;

import com.erosnox.imobli.core.auth.domain.models.request.LoginRequest;
import com.erosnox.imobli.core.auth.domain.models.response.LoginResponse;

public interface LoginService {
    LoginResponse login(LoginRequest loginRequest);
}
