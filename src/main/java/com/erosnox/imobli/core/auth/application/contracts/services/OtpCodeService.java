package com.erosnox.imobli.core.auth.application.contracts.services;

import com.erosnox.imobli.core.auth.application.dto.OtpDto;

import java.util.UUID;

public interface OtpCodeService {
    String generateOtpCode(int length);
    void saveOtpCode(String otpCode, UUID userId);
    OtpDto validateOtpCode(String otpCode);
}
