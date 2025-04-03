package com.erosnox.imobli.core.auth.application.contracts.usecases;

public interface ConfirmEmailUseCase {
    void execute(String otpCode);
}
