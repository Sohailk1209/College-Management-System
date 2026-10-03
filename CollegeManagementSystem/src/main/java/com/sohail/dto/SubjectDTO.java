package com.sohail.dto;

import com.sohail.entity.Professor;
import com.sohail.entity.Student;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubjectDTO {

    private Long id;

    private String name;

    private Professor professor;

    private Set<Student> students = new HashSet<>();
}
