package com.erosnox.imobli.core.auth.application.contracts.usecases;

import com.erosnox.imobli.core.auth.domain.models.request.RegisterRequest;
import com.erosnox.imobli.core.auth.domain.models.response.RegisterResponse;

public interface RegisterUseCase {
    RegisterResponse execute(RegisterRequest request);
}
