package com.satyam.academia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.satyam.academia.entity.Department;
import jakarta.validation.constraints.*;

public record EmployeeRequest(
    @NotNull(message = "Employee should be present")
    @NotEmpty(message = "Employee should be present")
    @NotBlank(message = "Employee should be present")
    @JsonProperty("first_name")
    String firstName,

    @JsonProperty("last_name")
    String lastName,

    @NotNull(message="Employee email is required")
    @Email(message = "Email must be in correct format")
    @JsonProperty("email")
    String email,

    @NotNull(message = "Password should be present")
    @NotEmpty(message = "Password should be present")
    @NotBlank(message = "Password should be present")
    @Size(min = 6, max = 12)
    @JsonProperty("password")
    String password,

    @NotNull(message="Employee title is required")
    @NotEmpty(message = "Employee title should be present")
    @JsonProperty("title")
    String title,

    @JsonProperty("photographPath")
    String photographPath,

    @NotNull(message="Employee department is required")
    @NotEmpty(message = "Employee department should be present")
    @JsonProperty("department_id")
    Department department
) {
    }