package com.satyam.academia.controller;

import com.satyam.academia.dto.SpecializationRequest;
import com.satyam.academia.dto.SpecializationResponse;
import com.satyam.academia.service.SpecializationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/specializations")
public class SpecializationController {
    private final SpecializationService specializationService;

    @GetMapping
    public ResponseEntity<List<SpecializationResponse>> getAllSpecializations() {
        return ResponseEntity.ok(specializationService.getAllSpecializations());
    }


    @GetMapping("/course/{id}")
    public ResponseEntity<SpecializationResponse> getSpecialization(@PathVariable Long id) {
        return ResponseEntity.ok(specializationService.getSpecialization(id));
    }

    @PostMapping
    public ResponseEntity<SpecializationResponse> createSpecialization(
            @RequestBody @Valid SpecializationRequest request) {
        return ResponseEntity.ok(specializationService.createSpecialization(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpecializationResponse> updateSpecialization(
            @PathVariable Long id, @RequestBody @Valid SpecializationRequest request) {
        return ResponseEntity.ok(specializationService.updateSpecialization(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpecialization(@PathVariable Long id) {
        specializationService.deleteSpecialization(id);
        return ResponseEntity.noContent().build();
    }
}