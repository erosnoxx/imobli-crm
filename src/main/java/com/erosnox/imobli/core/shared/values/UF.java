package com.erosnox.imobli.core.shared.values;

import com.erosnox.imobli.core.shared.values.common.BaseValue;

public class UF extends BaseValue {
    private String value;

    public UF(String value) {
        setValue(value);
    }

    public void setValue(String value) {
        validate(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    private void validate(String value) {
        isFieldEmpty(value, "UF");
        String[] ufs = {
                "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA",
                "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN",
                "RS", "RO", "RR", "SC", "SP", "SE", "TO"
        };

        for (var uf : ufs) {
            if (uf.equals(value)) {
                return;
            }
        }
        throw new IllegalArgumentException(value + " is not a valid UF");
    }
}
