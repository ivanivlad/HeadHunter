package com.example.hh_ru.vacancy_service;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
public class Vacancy {
    private @NonNull String jobTitle;
    private @NonNull String jobDescription;
    private @NonNull BigDecimal salary;
    private @NonNull String currency;
}
