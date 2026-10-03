package com.sohail.service.impl;

import com.sohail.entity.Professor;
import com.sohail.entity.Subject;
import com.sohail.exception.ResourceNotFoundException;
import com.sohail.repository.ProfessorRepository;
import com.sohail.repository.SubjectRepository;
import com.sohail.service.ProfessorSubjectMappingService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProfessorSubjectMappingImpl implements ProfessorSubjectMappingService {

    private final ModelMapper modelMapper;
    private final SubjectRepository subjectRepository;
    private final ProfessorRepository professorRepository;

    @Override
    @Transactional
    public void professorSubjectMappingWithProfessorId(Long id, List<Long> subjects) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("PROFESSOR NOT FOUND WITH ID : " + id));

        List<Subject> subjectList = new ArrayList<>();
        Set<Subject> subjectSet = new HashSet<>();

        for(long subjectId : subjects){
            Subject subject = subjectRepository.findById(subjectId)
                    .orElseThrow(() -> new ResourceNotFoundException("SUBJECT NOT FOUND WITH ID : " + subjectId));

            subject.setProfessor(professor);
            subjectList.add(subject);
            subjectSet.add(subject);
        }

        professor.setSubjects(subjectSet);
    }
}
