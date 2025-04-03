package com.erosnox.imobli.core.shared.values;

import com.erosnox.imobli.core.shared.values.common.BaseValue;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class Password extends BaseValue {
    private String value;

    public Password(String value) {
        changeValue(value);
    }

    public void changeValue(String value) {
        validate(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private void validate(String value) {
        isFieldEmpty(value, "Password");
        var passwordRegex = "^(?=.*[A-Za-z\\d])(?=.*\\W).{8,}$";

        if (!validateRegex(passwordRegex, value)) {
            throw new IllegalArgumentException("Invalid password");
        }
    }
}

