package com.satyam.academia.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "specialization_course")
public class SpecializationCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "specialization_id", referencedColumnName = "specialization_id")
    private Specialization specialization;

    @OneToOne
    @JoinColumn(name = "course_id",referencedColumnName = "course_id")
    private Course course;
}