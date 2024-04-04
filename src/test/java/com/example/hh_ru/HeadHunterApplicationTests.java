package com.example.hh_ru;

import com.example.hh_ru.recruting_service.RecruitingService;
import com.example.hh_ru.resume_service.Resume;
import com.example.hh_ru.resume_service.User;
import com.example.hh_ru.vacancy_service.Company;
import com.example.hh_ru.vacancy_service.Vacancy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("china")
class HeadHunterApplicationTests {

	@Autowired
	private RecruitingService recruitingService;

	@Test
	void contextLoads() {

		Company company = recruitingService.addCompany("ООО");
		Vacancy vacancy = recruitingService.addVacancy("Топить урановые ломы",
				"Топить урановые ломы в ртутной ванне",
				"100.5",
				"ООО");
		Vacancy vacancy2 = recruitingService.addVacancy("Вылавливать урановые ломы",
				"Вылавливать урановые ломы в ртутной ванне",
				"5",
				"ООО");
		List<Vacancy> vacancies = recruitingService.vacancyByCompany("ООО");
		assertEquals(2, vacancies.size());
		assertEquals(vacancy2, vacancies.get(1));

		User ivan = recruitingService.addUser("Ivan", "ivan@mail.ru");
		User ivan2 = recruitingService.addUser("Ivan", "ivan@gmail.com");
		Resume resumeIvan = recruitingService.addResume("Могу копать",
				"100.00",
				"ivan@mail.ru");
		Resume resumeIvan2 = recruitingService.addResume("Могу не копать",
				"100000",
				"ivan@gmail.com");
		List<Resume> resumes = recruitingService.getResumes();

		assertEquals(new BigDecimal("100.00"), resumeIvan.getSalary());
		assertEquals(2, resumes.size());
	}

}
