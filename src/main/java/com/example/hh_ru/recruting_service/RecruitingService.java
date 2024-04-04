package com.example.hh_ru.recruting_service;

import com.example.hh_ru.resume_service.Resume;
import com.example.hh_ru.resume_service.ResumeService;
import com.example.hh_ru.resume_service.User;
import com.example.hh_ru.vacancy_service.Company;
import com.example.hh_ru.vacancy_service.Vacancy;
import com.example.hh_ru.vacancy_service.VacancyService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecruitingService {
    private final VacancyService vacancyService;
    private final ResumeService resumeService;

    public Company addCompany(String name) {
        return vacancyService.addCompany(name);
    }

    public Vacancy addVacancy(String jobTitle, String jobDescription, String salary, String companyName) {
        return vacancyService.addVacancy(jobTitle, jobDescription, new BigDecimal(salary), companyName);
    }

    public List<Vacancy> vacancyByCompany(String companyName) {
        return vacancyService.vacancyByCompany(companyName);
    }

    public User addUser(String name, String email) {
        return resumeService.addUser(name, email);
    }

    public Resume addResume(@NonNull String skills, @NonNull String salary, @NonNull String email) {
        return resumeService.addResumeForUser(skills, new BigDecimal(salary), email);
    }

    public List<Resume> getResumes() {
        return resumeService.getResumes();
    }

}
