package com.satyam.academia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import java.util.List;

@Builder
public record SpecializationResponse(
        Long id,
        String code,
        String name,
        String description,
        Integer year,
        Integer creditsRequired
) {}