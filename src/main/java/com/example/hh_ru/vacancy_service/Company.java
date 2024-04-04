package com.example.hh_ru.vacancy_service;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Getter
public class Company {
    private @NonNull final String name;
    private final List<Vacancy> vacancies = new ArrayList<>();

    public Vacancy addVacancy(String jobTitle, String jobDescription, BigDecimal salary, String currency) {
        Vacancy vacancy = new Vacancy(jobTitle, jobDescription, salary, currency);
        vacancies.add(vacancy);
        return vacancy;
    }
}
