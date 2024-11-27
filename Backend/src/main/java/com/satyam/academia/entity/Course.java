package com.satyam.academia.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="course_id")
    private Long courseId;

    @Column(name = "course_code", unique = true, nullable = false)
    private String courseCode;

    @Column(name = "course_name", nullable = false)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

    @Column(name = "year", nullable = true)
    private Integer year;

    @Column(name = "term", nullable = true)
    private String term;

    @Column(name = "faculty", nullable = true)
    private String faculty;

    @Column(name = "credits", nullable = true)
    private Integer credits;

    @Column(name = "capacity", nullable = true)
    private Integer capacity;

}