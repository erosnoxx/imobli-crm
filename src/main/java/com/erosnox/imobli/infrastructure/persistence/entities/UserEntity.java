package com.erosnox.imobli.infrastructure.persistence.entities;

import com.erosnox.imobli.core.auth.application.enums.Roles;
import com.erosnox.imobli.infrastructure.persistence.entities.common.BaseJpaEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity @Table(name = "users")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class UserEntity extends BaseJpaEntity<UUID> implements UserDetails {
    private String email;
    private String passwordHash;
    @Enumerated(EnumType.STRING)
    private Roles role;
    private boolean enabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        switch (role) {
            case ADMIN:
                return List.of(
                        new SimpleGrantedAuthority("ROLE_ADMIN"),
                        new SimpleGrantedAuthority("ROLE_MANAGER"),
                        new SimpleGrantedAuthority("ROLE_BROKER"),
                        new SimpleGrantedAuthority("ROLE_BACKOFFICE"));
            case MANAGER:
                return List.of(
                        new SimpleGrantedAuthority("ROLE_MANAGER"),
                        new SimpleGrantedAuthority("ROLE_BROKER"),
                        new SimpleGrantedAuthority("ROLE_BACKOFFICE"));
            case BROKER:
                return List.of(
                        new SimpleGrantedAuthority("ROLE_BROKER"),
                        new SimpleGrantedAuthority("ROLE_BACKOFFICE"));
            case BACKOFFICE:
                return List.of(new SimpleGrantedAuthority("ROLE_BACKOFFICE"));
            default:
                throw new IllegalStateException("Unsupported role: " + role);
        }
    }

    @Override
    public String getPassword() {
        return passwordHash;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }
}
