package com.satyam.academia.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "specialization")
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "specialization_id")
    private Long specializationId;

    @Column(name = "code", unique = true, nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "creditsRequired", nullable = false)
    private Integer creditsRequired;

}