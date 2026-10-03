package com.sohail.service;

import com.sohail.entity.Subject;

import java.util.List;

public interface ProfessorSubjectMappingService {
    void professorSubjectMappingWithProfessorId(Long id, List<Long> subjects);
}
