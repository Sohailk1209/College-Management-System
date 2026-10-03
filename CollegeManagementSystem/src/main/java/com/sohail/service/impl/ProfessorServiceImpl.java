package com.sohail.service.impl;

import com.sohail.dto.ProfessorDTO;
import com.sohail.entity.Professor;
import com.sohail.exception.ResourceNotFoundException;
import com.sohail.repository.ProfessorRepository;
import com.sohail.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessorServiceImpl implements ProfessorService {

    private final ModelMapper modelMapper;
    private final ProfessorRepository professorRepository;


    @Override
    public ProfessorDTO addProfessor(ProfessorDTO professor) {
        Professor professorToBeSaved = modelMapper.map(professor , Professor.class);
        Professor savedProfessor = professorRepository.save(professorToBeSaved);
        return modelMapper.map(savedProfessor , ProfessorDTO.class);
    }

    @Override
    public List<ProfessorDTO> getAllProfessor() {
        return professorRepository.findAll()
                .stream()
                .map(professor -> modelMapper.map(professor , ProfessorDTO.class))
                .toList();
    }

    @Override
    public ProfessorDTO getProfessorById(Long id) {
        Optional<Professor> professor = professorRepository.findById(id);

        if(professor.isPresent()){
            return modelMapper.map(professor.get() , ProfessorDTO.class);
        }
        else{
            throw new ResourceNotFoundException("PROFESSOR NOT FOUND WITH ID : " + id);
        }
    }

    @Override
    public Boolean deleteProfessorWithId(Long id) {
        Optional<Professor> professor = professorRepository.findById(id);

        if(professor.isPresent()){
            professorRepository.delete(professor.get());
            return true;
        }
        else{
            throw new ResourceNotFoundException("PROFESSOR NOT FOUND WITH ID : " + id);
        }
    }

    @Override
    public ProfessorDTO updateProfessorById(Long id , ProfessorDTO update) {
        Optional<Professor> professor = professorRepository.findById(id);

        if(professor.isPresent()){
           Professor professorToBeUpdated = professor.get();
           professorToBeUpdated = modelMapper.map(update , Professor.class);
           professorToBeUpdated.setId(id);
           return modelMapper.map(professorRepository.save(professorToBeUpdated) , ProfessorDTO.class);
        }
        else{
            throw new ResourceNotFoundException("PROFESSOR NOT FOUND WITH ID : " + id);
        }
    }

    @Override
    public ProfessorDTO partiallyUpdateProfessorById(Long id, Map<String, Object> updates) throws IllegalAccessException {
        Optional<Professor> professor = professorRepository.findById(id);

        if(professor.isPresent()){
            Professor professorToBeUpdated = professor.get();

            Class<?> c1 = professorToBeUpdated.getClass();
            Field fields[] = c1.getDeclaredFields();

            for(Field field : fields){
                if(updates.containsKey(field.getName())){
                    field.setAccessible(true);
                    field.set(professorToBeUpdated , updates.get(field.getName()));
                }
            }

            return modelMapper.map(
                    professorRepository.save(professorToBeUpdated) ,
                    ProfessorDTO.class
            );
        }
        else{
            throw new ResourceNotFoundException("PROFESSOR NOT FOUND WITH ID : " + id);
        }
    }
}
