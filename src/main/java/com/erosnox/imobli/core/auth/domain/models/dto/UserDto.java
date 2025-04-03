package com.erosnox.imobli.core.auth.domain.models.dto;

import com.erosnox.imobli.core.auth.application.enums.Roles;

import java.util.UUID;

public record UserDto(UUID id, Roles role) {
}
