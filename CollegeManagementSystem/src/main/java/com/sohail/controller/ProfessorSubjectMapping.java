package com.sohail.controller;

import com.sohail.entity.Subject;
import com.sohail.service.ProfessorSubjectMappingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/admin")
public class ProfessorSubjectMapping {

    private final ProfessorSubjectMappingService professorSubjectMappingService;

    @PostMapping(path = "/professorSubjectMappingWithProfessorId/{id}")
    public void professorSubjectMappingWithProfessorId(@PathVariable Long id , @RequestBody List<Long> subjects){
        professorSubjectMappingService.professorSubjectMappingWithProfessorId(id , subjects);
    }
}
