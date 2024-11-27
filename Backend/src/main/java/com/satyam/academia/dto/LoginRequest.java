package com.satyam.academia.dto;

import jakarta.validation.constraints.*;

public record LoginRequest(
        @NotNull(message = "Email is required")
        @Email(message = "Email must be in correct format")
        String email,

        @NotNull(message = "Password should be present")
        @NotEmpty(message = "Password should be present")
        @NotBlank(message = "Password should be present")
        @Size(min = 6, max = 12)
        String password
) {}