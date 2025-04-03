package com.erosnox.imobli.core.shared.values;


import com.erosnox.imobli.core.shared.values.common.BaseValue;

public class CEP extends BaseValue {
    private String value;

    public CEP(String value) {
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
        var cleanedValue = value.replaceAll("\\D", "");

        isFieldEmpty(cleanedValue, "CEP");
        var cepRegex = "^\\d{8}$";
        if (!validateRegex(cepRegex, cleanedValue)) {
            throw new IllegalArgumentException("Invalid CEP");
        }
    }
}
