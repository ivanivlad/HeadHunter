package com.example.hh_ru.resume_service;

import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;


@Getter
public class Resume {
    private @NonNull final String skills;
    private @NonNull final BigDecimal salary;

    public Resume(@NonNull String skills, @NonNull BigDecimal salary) {
        this.skills = skills;
        this.salary = salary;
    }
}
