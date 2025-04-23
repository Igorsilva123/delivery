package com.example.onepot.dto;

import com.example.onepot.entities.User.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

public record RegisterRequestDTO(
        @NotBlank
        String username,
        @NotBlank
        String secondname,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#])[A-Za-z\\d@$!%*?&#]{8,64}$")
        String password,
        @NotBlank
        @CPF
        String cpf,
        @NotBlank
        Role role
        ) {
}
