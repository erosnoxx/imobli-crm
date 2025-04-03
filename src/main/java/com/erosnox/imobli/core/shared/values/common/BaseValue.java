package com.erosnox.imobli.core.shared.values.common;

import java.util.regex.Pattern;

public abstract class BaseValue {
    protected static boolean validateRegex(String regexPattern, String value) {
        var pattern = Pattern.compile(regexPattern);
        return pattern.matcher(value).matches();
    }

    protected static void isFieldEmpty(String value, String fieldName) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(fieldName + " is null or empty");
        }
    }

    protected static String removeMask(String value) {
        return value.replaceAll("[^a-zA-Z0-9]", "");
    }
}
