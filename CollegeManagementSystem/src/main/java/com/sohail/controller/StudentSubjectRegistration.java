package com.sohail.controller;

import com.sohail.service.StudentSubjectRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/registration")
public class StudentSubjectRegistration {

    private final StudentSubjectRegistrationService studentSubjectRegistrationService;

    @PostMapping(path = "/studentSubjectRegistrationWithStudentId/{id}")
    public void studentSubjectRegistrationWithStudentId(@PathVariable Long id , @RequestBody List<Long> subjectIds){
        studentSubjectRegistrationService.studentSubjectRegistrationWithStudentId(id , subjectIds);
    }
}
