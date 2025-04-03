package com.erosnox.imobli.core.shared.values;


import com.erosnox.imobli.core.shared.values.common.BaseDocument;

public class CPF extends BaseDocument {
    private String value;

    public CPF(String value) {
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

        isFieldEmpty(cleanedValue, "CPF");
        String CPF_REGEX = "\\d{11}";
        if (!validateRegex(CPF_REGEX, cleanedValue)) {
            throw new IllegalArgumentException("CPF cannot contain illegal characters");
        }

        if (!isValidDocument(cleanedValue)) {
            throw new IllegalArgumentException("Fake CPFs are not valid");
        }
    }
}
