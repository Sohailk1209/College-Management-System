package com.sohail.dto;

import com.sohail.entity.Professor;
import com.sohail.entity.Subject;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {

    private Long id;

    private String name;

    private Set<Professor> professors = new HashSet<>();

    private Set<Subject> subjects = new HashSet<>();
}
