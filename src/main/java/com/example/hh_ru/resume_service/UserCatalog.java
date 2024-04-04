package com.example.hh_ru.resume_service;

import com.example.hh_ru.Catalog;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class UserCatalog implements Catalog<User> {
    private final Map<String, User> users = new LinkedHashMap<>();

    public void add(User user) {
        users.put(user.getEmail(), user);
    }

    public Optional<User> findByName(String name) {
        return users.values().stream().filter(e -> e.getName().equals(name)).findFirst();
    }

    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(users.get(email));
    }

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public void deleteAll() {
        users.clear();
    }

    public User createUser(@NonNull String userName, @NonNull String userEmail) {
        return new User(userName, userEmail);
    }
}
