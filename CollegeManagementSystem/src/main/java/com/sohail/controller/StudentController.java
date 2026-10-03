package com.sohail.controller;

import com.sohail.dto.StudentDTO;
import com.sohail.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping(path = "/getAllStudent")
    public List<StudentDTO> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping(path = "/getStudentById/{id}")
    public StudentDTO getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PutMapping(path = "/updateStudentById/{id}")
    public StudentDTO updateStudentById(@PathVariable Long id , @RequestBody StudentDTO update){
        return studentService.updateStudentById(id , update);
    }

    @PatchMapping(path = "/partiallyUpdateStudentById/{id}")
    public StudentDTO partiallyUpdateStudentById(@PathVariable Long id , @RequestBody Map<String , Object> updates) throws IllegalAccessException {
        return studentService.partiallyUpdateStudentById(id , updates);
    }
}
