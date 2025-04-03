package com.erosnox.imobli.infrastructure.services;

import com.erosnox.imobli.core.auth.application.contracts.services.OtpCodeService;
import com.erosnox.imobli.core.auth.application.dto.OtpDto;
import com.erosnox.imobli.core.shared.contracts.TempStorageService;
import com.erosnox.imobli.core.shared.exceptions.NotFoundException;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.UUID;

@Service
public class OtpCodeServiceImpl implements OtpCodeService {
    private static final String DIGITS = "0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();
    private static final String KEY_PREFIX = "otp:temp";
    private final Gson gson = new Gson();

    @Autowired
    private TempStorageService tempStorageService;

    @Override
    public String generateOtpCode(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }

        var otp = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            otp.append(DIGITS.charAt(RANDOM.nextInt(DIGITS.length())));
        }
        return otp.toString();
    }

    @Override
    public void saveOtpCode(String otpCode, UUID userId) {
        var key = KEY_PREFIX + otpCode;
        var json = gson.toJson(new OtpDto(otpCode, userId));

        tempStorageService.save(key, json, Duration.ofMinutes(5).toSeconds());
    }

    @Override
    public OtpDto validateOtpCode(String otpCode) {
        var key = KEY_PREFIX + otpCode;
        var storedOtp = tempStorageService.get(key);

        if (storedOtp == null) {
            throw new NotFoundException("Otp code not found");
        }

        var dto = gson.fromJson(storedOtp, OtpDto.class);
        tempStorageService.delete(key);
        return dto;
    }
}
