package com.erosnox.imobli.core.auth.application.mappers;

import com.erosnox.imobli.core.auth.application.enums.Roles;
import com.erosnox.imobli.core.auth.domain.entities.User;
import com.erosnox.imobli.core.auth.domain.models.request.RegisterRequest;
import com.erosnox.imobli.core.auth.domain.models.response.RegisterResponse;

public class UserMapper {
    public static User fromRequest(
            String email, String passwordHash,
            Roles role, boolean enabled) {
        return new User(
                email, passwordHash,
                role, enabled
        );
    }

    public static RegisterResponse toResponse(User user) {
        return new RegisterResponse(
                user.getId()
        );
    }
}
