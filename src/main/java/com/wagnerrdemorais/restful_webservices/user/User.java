package com.wagnerrdemorais.restful_webservices.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class User {

    private int id;

    @Size(min = 2, message = "Should have at least 2 characters")
    private String name;

    @Past(message = "Should be in the past")
    private LocalDate birthDate;
}
