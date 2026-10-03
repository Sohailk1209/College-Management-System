package com.sohail.service;

import com.sohail.dto.ProfessorDTO;

import java.util.List;
import java.util.Map;

public interface ProfessorService {
    ProfessorDTO addProfessor(ProfessorDTO professor);

    List<ProfessorDTO> getAllProfessor();

    ProfessorDTO getProfessorById(Long id);

    Boolean deleteProfessorWithId(Long id);

    ProfessorDTO updateProfessorById(Long id , ProfessorDTO update);

    ProfessorDTO partiallyUpdateProfessorById(Long id, Map<String, Object> updates) throws IllegalAccessException;
}
