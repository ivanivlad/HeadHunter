package com.example.hh_ru.resume_service;

import lombok.Data;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Data
@ToString
public class User {
    private @NonNull String name;
    private @NonNull String email;
    @Setter
    private Resume resume;
}
