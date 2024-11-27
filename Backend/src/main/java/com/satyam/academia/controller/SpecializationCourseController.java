package com.satyam.academia.controller;


import com.satyam.academia.entity.Course;
import com.satyam.academia.service.SpecializationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/specializationcourse")
public class SpecializationCourseController {
    private final SpecializationService specializationService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Course>> getSpecializationCourse(@PathVariable Long id) {
        return ResponseEntity.ok(specializationService.getSpecializationCourse(id));
    }
}
