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
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false , length = 200)
    private String name;

    @OneToMany(mappedBy = "professor")
    private Set<Subject> subjects = new HashSet<>();

    @ManyToMany(mappedBy = "professors")
    private Set<Student> students = new HashSet<>();
}
