package com.example.hh_ru.vacancy_service;

import com.example.hh_ru.Catalog;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class CompanyCatalog implements Catalog<Company> {
    private final Map<String, Company> companies = new LinkedHashMap<>();

    public void add(Company company) {
        companies.put(company.getName(), company);
    }

    public Optional<Company> findByName(String name) {
        return Optional.ofNullable(companies.get(name));
    }

    public List<Company> findAll() {
        return new ArrayList<>(companies.values());
    }

    public void deleteAll() {
        companies.clear();
    }

    public Company createCompany(@NonNull String companyName) {
        return new Company(companyName);
    }
}
