package com.satyam.academia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record SpecializationRequest(
        @NotNull(message = "Code should be present")
        @NotEmpty(message = "Code should be present")
        @JsonProperty("code")
        String code,

        @NotNull(message = "Name should be present")
        @NotEmpty(message = "Name should be present")
        @JsonProperty("name")
        String name,

        @NotNull(message = "Description should be present")
        @NotEmpty(message = "Description should be present")
        @JsonProperty("description")
        String description,

        @NotNull(message = "Year should be present")
        @JsonProperty("year")
        Integer year,

        @NotNull(message = "Credits required should be present")
        @Min(value = 0, message = "Credits required should be positive")
        @JsonProperty("credits_required")
        Integer creditsRequired

) {}