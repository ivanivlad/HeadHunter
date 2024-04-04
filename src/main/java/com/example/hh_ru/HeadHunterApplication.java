package com.example.hh_ru;

import com.example.hh_ru.recruting_service.RecruitingService;
import com.example.hh_ru.vacancy_service.Company;
import com.example.hh_ru.vacancy_service.Vacancy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.math.BigDecimal;

@SpringBootApplication
public class HeadHunterApplication {

    public static void main(String[] args) {
        ApplicationContext run = SpringApplication.run(HeadHunterApplication.class, args);
        RecruitingService service = run.getBean(RecruitingService.class);
        Company company = service.addCompany("ООО");
        Vacancy vacancy = company.addVacancy("dd", "dd", new BigDecimal("22"), "Юань");
        System.out.println(vacancy);
    }
}
