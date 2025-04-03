package com.erosnox.imobli.core.auth.application.dto;

import java.util.UUID;

public record OtpDto(String otpCode, UUID userId) {
}
