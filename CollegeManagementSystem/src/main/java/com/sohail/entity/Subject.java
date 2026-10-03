package com.sohail.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false , length = 200)
    private String name;

    @ManyToOne
    private Professor professor;

    @ManyToMany(mappedBy = "subjects")
    private Set<Student> students = new HashSet<>();
}
