package com.sohail.service.impl;

import com.sohail.entity.Professor;
import com.sohail.entity.Student;
import com.sohail.entity.Subject;
import com.sohail.exception.ResourceNotFoundException;
import com.sohail.repository.ProfessorRepository;
import com.sohail.repository.StudentRepository;
import com.sohail.repository.SubjectRepository;
import com.sohail.service.StudentSubjectRegistrationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentSubjectRegistrationServiceImpl implements StudentSubjectRegistrationService {

    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;
    private final SubjectRepository subjectRepository;

    @Override
    @Transactional
    public void studentSubjectRegistrationWithStudentId(Long id, List<Long> subjectIds) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("STUDENT NOT FOUND WITH ID : " + id));

        Set<Subject> subjectSet = new HashSet<>();
        Set<Professor> professorSet = new HashSet<>();

        for(long subjectId : subjectIds){
            Subject subject = subjectRepository.findById(subjectId)
                    .orElseThrow(() -> new ResourceNotFoundException("SUBJECT NOT FOUND WITH ID : " + subjectId));

            subjectSet.add(subject);
            professorSet.add(subject.getProfessor());
        }

        student.setSubjects(subjectSet);
        student.setProfessors(professorSet);
    }
}
