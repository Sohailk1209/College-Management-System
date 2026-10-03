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
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false , length = 200)
    private String name;

    @ManyToMany
    private Set<Professor> professors = new HashSet<>();

    @ManyToMany
    private Set<Subject> subjects = new HashSet<>();
}
