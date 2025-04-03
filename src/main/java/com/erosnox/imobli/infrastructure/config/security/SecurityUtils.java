package com.erosnox.imobli.infrastructure.config.security;

import com.erosnox.imobli.core.auth.domain.models.dto.UserDto;
import com.erosnox.imobli.infrastructure.persistence.entities.UserEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtils {

    public static UserDto getCurrentUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !(authentication.getPrincipal() instanceof UserEntity)) {
            throw new IllegalStateException("Usuário não autenticado ou token inválido");
        }

        var user = (UserEntity) authentication.getPrincipal();
        return new UserDto(user.getId(), user.getRole());
    }
}
