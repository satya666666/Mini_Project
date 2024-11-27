package com.satyam.academia.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record CourseResponse(
        Long id,
        @JsonProperty("course_code")
        String courseCode,
        String name,
        String description,
        Integer year,
        String term,
        String faculty,
        Integer credits,
        Integer capacity
) {}