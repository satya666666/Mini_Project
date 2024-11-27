package com.satyam.academia.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "capacity", nullable = true)
    private Integer capacity;

}
