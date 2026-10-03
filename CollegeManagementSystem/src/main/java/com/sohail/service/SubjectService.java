package com.sohail.service;

import com.sohail.dto.SubjectDTO;

import java.util.List;
import java.util.Map;

public interface SubjectService {
    SubjectDTO addNewSubject(SubjectDTO request);

    List<SubjectDTO> getAllSubject();

    SubjectDTO getSubjectById(Long id);

    Boolean deleteSubjectWithId(Long id);

    SubjectDTO updateSubjectWithId(Long id, SubjectDTO update);

    SubjectDTO partiallyUpdateSubjectWithId(Long id, Map<String, Object> updates) throws IllegalAccessException;
}
