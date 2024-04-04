package com.example.hh_ru.vacancy_service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyService {
    private final CompanyCatalog companyCatalog;
    @Value("${salary.currency}")
    private String currency;

    public Vacancy addVacancy(String jobTitle, String jobDescription, BigDecimal salary, String companyName) {
        Company company = companyCatalog.findByName(companyName).orElseThrow();
        return company.addVacancy(jobTitle, jobDescription, salary, currency);
    }

    public Company addCompany(@NonNull String companyName) {
        if (companyCatalog.findByName(companyName).isPresent()) {
            throw new RuntimeException("Организация с таким именем уже есть");
        }
        Company company = companyCatalog.createCompany(companyName);
        companyCatalog.add(company);
        return company;
    }

    public List<Vacancy> vacancyByCompany(@NonNull String companyName) {
        Company company = companyCatalog.findByName(companyName).orElseThrow();
        return company.getVacancies();
    }
}
