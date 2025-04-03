package com.erosnox.imobli.core.shared.values;


import com.erosnox.imobli.core.shared.values.common.BaseValue;

public class Email extends BaseValue {
    private String value;

    public Email(String value) {
        changeValue(value);
    }

    public String getValue() {
        return value;
    }

    public void changeValue(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        isFieldEmpty(value, "Email");
        String EMAIL_REGEX = "(?i)\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}\\b";
        if (!validateRegex(EMAIL_REGEX, value)) {
            throw new IllegalArgumentException("Invalid Email");
        }
    }
}
