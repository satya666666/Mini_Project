package com.satyam.academia.repo;

import com.satyam.academia.entity.Course;
import com.satyam.academia.entity.Specialization;
import com.satyam.academia.entity.SpecializationCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface SpecializationCourseRepo extends JpaRepository<SpecializationCourse, Long> {
    List<SpecializationCourse> findBySpecialization (Specialization spec);

    @Query("SELECT c FROM SpecializationCourse sc " +
            "JOIN sc.course c " +
            "JOIN sc.specialization s " +
            "WHERE s.specializationId = :specializationId")
    List<Course> findCoursesBySpecializationId(Long specializationId);
}
