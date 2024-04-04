package com.example.hh_ru;

import java.util.List;
import java.util.Optional;

public interface Catalog<T> {
    void add(T entity);
    Optional<T> findByName(String name);
    List<T> findAll();
    void deleteAll();
}
