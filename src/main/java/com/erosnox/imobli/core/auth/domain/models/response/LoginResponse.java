package com.erosnox.imobli.core.auth.domain.models.response;

import java.util.UUID;

public record LoginResponse(String token, UUID userId) {
}
