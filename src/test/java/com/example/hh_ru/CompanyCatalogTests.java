package com.example.hh_ru;

import com.example.hh_ru.vacancy_service.Company;
import com.example.hh_ru.vacancy_service.CompanyCatalog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ActiveProfiles("china")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CompanyCatalogTests {

    @Autowired
    private CompanyCatalog companyCatalog;

    @BeforeEach
    void init() {
        companyCatalog.deleteAll();
    }

    @Test
    void addCompanySuccess() {
        Company company = companyCatalog.createCompany("ООО");
        assertEquals("ООО", company.getName());
        companyCatalog.add(company);
        assertEquals(1, companyCatalog.findAll().size());
    }

    @Test
    void findByNameSuccess() {
        Company company = companyCatalog.createCompany("ООО");
        companyCatalog.add(company);
        assertEquals(company, companyCatalog.findByName("ООО").get());
        assertThrows(RuntimeException.class, () -> companyCatalog.findByName("BBB").orElseThrow());
    }

    @Test
    void findAllSuccess() {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Stream.generate(atomicInteger::incrementAndGet).limit(10)
                .map(e -> companyCatalog.createCompany("BBB" + e.toString()))
                .forEach(e -> companyCatalog.add(e));
        assertEquals(10, companyCatalog.findAll().size());
    }
}
