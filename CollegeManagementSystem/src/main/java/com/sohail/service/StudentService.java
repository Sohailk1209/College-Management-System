package com.sohail.service;

import com.sohail.dto.StudentDTO;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDTO> getAllStudent();

    StudentDTO getStudentById(Long id);

    StudentDTO updateStudentById(Long id, StudentDTO update);

    StudentDTO partiallyUpdateStudentById(Long id, Map<String, Object> updates) throws IllegalAccessException;
}
