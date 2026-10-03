package com.sohail.dto;

import com.sohail.entity.Student;
import com.sohail.entity.Subject;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfessorDTO {

    private Long id;

    private String name;

    private Set<Subject> subjects = new HashSet<>();

    private Set<Student> students = new HashSet<>();
}
