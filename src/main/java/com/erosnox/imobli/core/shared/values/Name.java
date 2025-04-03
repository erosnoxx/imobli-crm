package com.erosnox.imobli.core.shared.values;

import com.erosnox.imobli.core.shared.values.common.BaseValue;

public class Name extends BaseValue {
    private String value;

    public Name(String value) {
        changeName(value);
    }

    public void changeName(String name) {
        validate(name);
        this.value = name;
    }

    private void validate(String value) {
        isFieldEmpty(value, "Name");
        if (value.length() < 2 || value.length() > 30) {
            throw new IllegalArgumentException("Name must be between 2 and 30 characters");
        }
    }

    public String getValue() {
        return value;
    }
}
