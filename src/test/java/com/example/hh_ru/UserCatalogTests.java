package com.example.hh_ru;

import com.example.hh_ru.resume_service.User;
import com.example.hh_ru.resume_service.UserCatalog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("china")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserCatalogTests {

    @Autowired
    private UserCatalog userCatalog;

    @BeforeEach
    void init() {
        userCatalog.deleteAll();
    }

    @Test
    void addUserSuccess() {
        User ivan = userCatalog.createUser("Ivan", "ivan@mail.ru");
        assertEquals("Ivan", ivan.getName());
        assertEquals("ivan@mail.ru", ivan.getEmail());
        userCatalog.add(ivan);
        assertEquals(1, userCatalog.findAll().size());
        User ivan2 = userCatalog.createUser("Ivan", "ivan@yopmail.com");
        userCatalog.add(ivan2);
        assertEquals(2, userCatalog.findAll().size());

    }
}
