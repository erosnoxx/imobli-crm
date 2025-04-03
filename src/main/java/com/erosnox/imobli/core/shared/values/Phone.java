package com.erosnox.imobli.core.shared.values;


import com.erosnox.imobli.core.shared.values.common.BaseValue;

public class Phone extends BaseValue {
    private String value;

    public Phone(String value) {
        changeValue(value);
    }

    public String getValue() {
        return addMask(removeMask(value));
    }

    public void changeValue(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        var cleanedValue = value.replaceAll("\\D", "");

        isFieldEmpty(cleanedValue, "Phone Number");
        String PHONE_REGEX = "^\\d{2}9\\d{8}$";
        if (!validateRegex(PHONE_REGEX, cleanedValue)) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }
    }

    private String addMask(String value) {
        return String.format("(%s) %s %s-%s",
                value.substring(0, 2),
                value.charAt(2),
                value.substring(3, 7),
                value.substring(7));
    }
}
