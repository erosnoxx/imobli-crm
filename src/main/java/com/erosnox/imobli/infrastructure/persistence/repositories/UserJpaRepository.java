package com.erosnox.imobli.infrastructure.persistence.repositories;

import com.erosnox.imobli.infrastructure.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {
    @Query("SELECT u FROM UserEntity u WHERE u.email = :email")
    UserDetails findUserByUsername(@Param("email") String email);

    boolean existsByEmail(String email);
    Optional<UserEntity> findByEmail(String email);
}
