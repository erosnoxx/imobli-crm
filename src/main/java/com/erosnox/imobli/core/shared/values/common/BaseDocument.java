package com.erosnox.imobli.core.shared.values.common;

public abstract class BaseDocument extends BaseValue {
    protected static boolean isValidDocument(String document) {
        int length = document.length();
        switch (length) {
            case 11:
                return isValidCPF(document);
            case 14:
                return isValidCNPJ(document);
            default:
                throw new IllegalArgumentException("Invalid document length");
        }
    }

    private static boolean isValidCPF(String document) {
        int[] weightsFirst = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] weightsSecond = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

        int firstDigit = calculateDigit(document, 9, weightsFirst);
        int secondDigit = calculateDigit(document, 10, weightsSecond);

        return document.charAt(9) == (char) (firstDigit + '0') &&
                document.charAt(10) == (char) (secondDigit + '0');
    }

    private static boolean isValidCNPJ(String document) {
        int[] weightsFirst = generateWeights(12);
        int[] weightsSecond = generateWeights(13);

        int firstDigit = calculateDigit(document, 12, weightsFirst);
        int secondDigit = calculateDigit(document, 13, weightsSecond);

        return document.charAt(12) == (char) (firstDigit + '0') &&
                document.charAt(13) == (char) (secondDigit + '0');
    }

    private static int calculateDigit(String document, int length, int[] weights) {
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += (document.charAt(i) - '0') * weights[i];
        }
        int remainder = sum % 11;
        return (remainder < 2) ? 0 : (11 - remainder);
    }

    private static int[] generateWeights(int size) {
        int[] weights = new int[size];
        int weight = size - 7;
        for (int i = 0; i < size; i++) {
            weights[i] = weight--;
            if (weight < 2) {
                weight = 9;
            }
        }
        return weights;
    }

    protected static String addMask(String document) {
        if (document == null || document.length() != 11 && document.length() != 14) {
            throw new IllegalArgumentException("Invalid document");
        }

        return switch (document.length()) {
            case 11 -> String.format("%s.%s.%s-%s",
                    document.substring(0, 3),
                    document.substring(3, 6),
                    document.substring(6, 9),
                    document.substring(9, 11));
            case 14 -> String.format("%s.%s.%s/%s-%s",
                    document.substring(0, 2),
                    document.substring(2, 5),
                    document.substring(5, 8),
                    document.substring(8, 12),
                    document.substring(12, 14));
            default -> throw new IllegalStateException("Unexpected value: " + document);
        };
    }
}