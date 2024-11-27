package com.satyam.academia.mapper;

import com.satyam.academia.dto.SpecializationRequest;
import com.satyam.academia.dto.SpecializationResponse;
import com.satyam.academia.entity.Specialization;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpecializationMapper {
    private final CourseMapper courseMapper;

    public Specialization toEntity(SpecializationRequest request) {
        return Specialization.builder()
                .code(request.code())
                .name(request.name())
                .description(request.description())
                .year(request.year())
                .creditsRequired(request.creditsRequired())
                .build();
    }

    public SpecializationResponse toResponse(Specialization entity) {
        return new SpecializationResponse(
                entity.getSpecializationId(),
                entity.getCode(),
                entity.getName(),
                entity.getDescription(),
                entity.getYear(),
                entity.getCreditsRequired()
        );
    }

    public void updateEntityFromRequest(Specialization entity, SpecializationRequest request) {
        entity.setCode(request.code());
        entity.setName(request.name());
        entity.setDescription(request.description());
        entity.setYear(request.year());
        entity.setCreditsRequired(request.creditsRequired());
    }
}
