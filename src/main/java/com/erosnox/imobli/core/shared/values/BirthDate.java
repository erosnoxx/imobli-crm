package com.erosnox.imobli.core.shared.values;

import java.time.LocalDate;
import java.time.Period;

public class BirthDate {
    private LocalDate value;
    private int age;

    public BirthDate(LocalDate value) {
        changeValue(value);
    }

    public LocalDate getValue() {
        return value;
    }

    public int getAge() {
        return age;
    }

    public void changeValue(LocalDate value) {
        validate(value);
        this.value = value;
    }

    private void validate(LocalDate value) {
        if (!value.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Birth date must be before today");
        }

        this.age = Period.between(value, LocalDate.now()).getYears();

        if (Period.between(value, LocalDate.now()).getYears() < 18) {
            throw new IllegalArgumentException("User must be at least 18 years old");
        }
    }
}
