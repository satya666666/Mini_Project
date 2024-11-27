package com.satyam.academia.service;

import com.satyam.academia.dto.SpecializationRequest;
import com.satyam.academia.dto.SpecializationResponse;
import com.satyam.academia.entity.Course;
import com.satyam.academia.entity.Specialization;
import com.satyam.academia.entity.SpecializationCourse;
import com.satyam.academia.mapper.SpecializationMapper;
import com.satyam.academia.repo.SpecializationCourseRepo;
import com.satyam.academia.repo.SpecializationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class SpecializationService {
    private final SpecializationRepository specializationRepository;
    private final SpecializationCourseRepo specializationCourseRepo;
    private final SpecializationMapper specializationMapper;

    public List<SpecializationResponse> getAllSpecializations() {
        System.out.println("===== in getall specialization");
        System.out.println("Found " + specializationRepository.findAll().size() + " specializations");

        return specializationRepository.findAll().stream()
                .map(specializationMapper::toResponse)
                .collect(Collectors.toList());
    }

    public List<Course> getSpecializationCourse(Long id)
    {
//        Specialization spec=Specialization.builder().specializationId(id).build();
//        List<SpecializationCourse> specCourses=specializationCourseRepo.findBySpecialization(spec);
        return specializationCourseRepo.findCoursesBySpecializationId(id);
    }


    public SpecializationResponse getSpecialization(Long id) {


        Specialization specialization = specializationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Specialization not found"));
        return specializationMapper.toResponse(specialization);
    }

    public SpecializationResponse createSpecialization(SpecializationRequest request) {
        Specialization specialization = specializationMapper.toEntity(request);
        specialization = specializationRepository.save(specialization);
        return specializationMapper.toResponse(specialization);
    }

    public SpecializationResponse updateSpecialization(Long id, SpecializationRequest request) {
        Specialization existing = specializationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Specialization not found"));

        specializationMapper.updateEntityFromRequest(existing, request);
        existing = specializationRepository.save(existing);
        return specializationMapper.toResponse(existing);
    }

    public void deleteSpecialization(Long id) {
        Specialization spec=Specialization.builder().specializationId(id).build();
        List<SpecializationCourse> specCourses=specializationCourseRepo.findBySpecialization(spec);
        specializationCourseRepo.deleteAll(specCourses);
        specializationRepository.deleteById(id);
    }
}