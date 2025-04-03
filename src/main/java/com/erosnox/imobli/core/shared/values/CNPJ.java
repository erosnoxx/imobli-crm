package com.erosnox.imobli.core.shared.values;

import com.erosnox.imobli.core.shared.values.common.BaseDocument;

public class CNPJ extends BaseDocument {
    private String value;

    public CNPJ(String value) {
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

        isFieldEmpty(cleanedValue, "CNPJ");
        String CNPJ_REGEX = "^\\d{14}$";
        if (!validateRegex(CNPJ_REGEX, cleanedValue)) {
            throw new IllegalArgumentException("CNPJ cannot contain illegal characters");
        }

        if (!isValidDocument(cleanedValue)) {
            throw new IllegalArgumentException("Fake CNPJs are not valid");
        }
    }
}
