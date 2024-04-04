package com.example.hh_ru.resume_service;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumeService {
    private final UserCatalog users;

    public Resume addResumeForUser(@NonNull String skills, @NonNull BigDecimal salary, @NonNull String userEmail) {
        User user = users.findByEmail(userEmail).orElseThrow();
        Resume resume = new Resume(skills, salary);
        user.setResume(resume);
        return resume;
    }

    public User addUser(@NonNull String userName, @NonNull String userEmail) {
        if (users.findByEmail(userEmail).isPresent()) {
            throw new RuntimeException("пользователь с такой почтой уже есть");
        }
        User user = new User(userName, userEmail);
        users.add(user);
        return user;
    }

    public List<Resume> getResumes() {
        return users.findAll().stream().map(User::getResume).toList();
    }
}
