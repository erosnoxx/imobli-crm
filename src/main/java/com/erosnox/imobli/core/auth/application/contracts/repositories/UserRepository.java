package com.erosnox.imobli.core.auth.application.contracts.repositories;

import com.erosnox.imobli.core.auth.domain.entities.User;
import com.erosnox.imobli.core.shared.common.BaseRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends BaseRepository<User, UUID> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String email);
    void activateUser(UUID userId);
}
