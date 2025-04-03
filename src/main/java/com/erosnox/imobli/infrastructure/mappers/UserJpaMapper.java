package com.erosnox.imobli.infrastructure.mappers;

import com.erosnox.imobli.core.auth.domain.entities.User;
import com.erosnox.imobli.infrastructure.persistence.entities.UserEntity;

public class UserJpaMapper {
    public static User fromJpa(UserEntity entity) {
        var user = new User(
                entity.getEmail(),
                entity.getPasswordHash(),
                entity.getRole(),
                entity.isEnabled());
        user.setId(entity.getId());
        return user;
    }

    public static UserEntity toJpa(User user) {
        return UserEntity.builder()
                .email(user.getEmail())
                .passwordHash(user.getPassword())
                .role(user.getRole())
                .enabled(user.isEnabled())
                .build();
    }
}
