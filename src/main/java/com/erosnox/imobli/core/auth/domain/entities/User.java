package com.erosnox.imobli.core.auth.domain.entities;

import com.erosnox.imobli.core.auth.application.enums.Roles;
import com.erosnox.imobli.core.shared.common.BaseEntity;
import com.erosnox.imobli.core.shared.values.Email;
import com.erosnox.imobli.core.shared.values.Password;

import java.util.UUID;

public class User extends BaseEntity<UUID> {
    private Email email;
    private Password password;
    private Roles role;
    private boolean enabled;

    public User(String email, String password, Roles role, boolean enabled) {
        setEmail(email);
        setPassword(password);
        setRole(role);
        setEnabled(enabled);
    }

    public void setEmail(String email) {
        this.email = new Email(email);
    }

    public void setPassword(String password) {
        this.password = new Password(password);
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getEmail() {
        return email.getValue();
    }

    public String getPassword() {
        return password.getValue();
    }

    public Roles getRole() {
        return role;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
