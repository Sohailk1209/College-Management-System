package com.sohail.controller;

import com.sohail.dto.SubjectDTO;
import com.sohail.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping(path = "/addNewSubject")
    public SubjectDTO addNewSubject(@RequestBody SubjectDTO request){
        return subjectService.addNewSubject(request);
    }

    @GetMapping(path = "/getAllSubject")
    public List<SubjectDTO> getAllSubject(){
        return subjectService.getAllSubject();
    }

    @GetMapping(path = "/getSubjectById/{id}")
    public SubjectDTO getSubjectById(@PathVariable Long id){
        return subjectService.getSubjectById(id);
    }

    @DeleteMapping(path = "/deleteSubjectWithId/{id}")
    public Boolean deleteSubjectWithId(@PathVariable Long id){
        return subjectService.deleteSubjectWithId(id);
    }

    @PutMapping(path = "/updateSubjectWithId/{id}")
    public SubjectDTO updateSubjectWithId(@PathVariable Long id , @RequestBody SubjectDTO update){
        return subjectService.updateSubjectWithId(id , update);
    }

    @PatchMapping(path = "/partiallyUpdateSubjectWithId/{id}")
    public SubjectDTO partiallyUpdateSubjectWithId(@PathVariable Long id , Map<String , Object> updates) throws IllegalAccessException {
        return subjectService.partiallyUpdateSubjectWithId(id , updates);
    }
}
