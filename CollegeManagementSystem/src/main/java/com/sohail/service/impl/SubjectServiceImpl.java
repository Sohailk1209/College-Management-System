package com.sohail.service.impl;

import com.sohail.dto.SubjectDTO;
import com.sohail.entity.Subject;
import com.sohail.exception.ResourceNotFoundException;
import com.sohail.repository.SubjectRepository;
import com.sohail.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final ModelMapper modelMapper;
    private final SubjectRepository subjectRepository;

    @Override
    public SubjectDTO addNewSubject(SubjectDTO request) {
        Subject subjectToBeSaved = modelMapper.map(request , Subject.class);
        return modelMapper.map(subjectRepository.save(subjectToBeSaved) , SubjectDTO.class);
    }

    @Override
    public List<SubjectDTO> getAllSubject() {
        return subjectRepository.findAll()
                .stream()
                .map(subject -> modelMapper.map(subject , SubjectDTO.class))
                .toList();
    }

    @Override
    public SubjectDTO getSubjectById(Long id) {
        Optional<Subject> subject = subjectRepository.findById(id);

        if(subject.isPresent()){
            return modelMapper.map(subject.get() , SubjectDTO.class);
        }
        else{
            throw new ResourceNotFoundException("SUBJECT NOT FOUND WITH ID : " + id);
        }
    }

    @Override
    public Boolean deleteSubjectWithId(Long id) {
        Optional<Subject> subject = subjectRepository.findById(id);

        if(subject.isPresent()){
            subjectRepository.delete(subject.get());
            return true;
        }
        else{
            throw new ResourceNotFoundException("SUBJECT NOT FOUND WITH ID : " + id);
        }
    }

    @Override
    public SubjectDTO updateSubjectWithId(Long id, SubjectDTO update) {
        Optional<Subject> subject = subjectRepository.findById(id);

        if(subject.isPresent()){
            Subject subjectTOBeUpdated = subject.get();
            subjectTOBeUpdated = modelMapper.map(update , Subject.class);
            subjectTOBeUpdated.setId(id);

            return modelMapper.map(subjectRepository.save(subjectTOBeUpdated) , SubjectDTO.class);
        }
        else{
            throw new ResourceNotFoundException("SUBJECT NOT FOUND WITH ID : " + id);
        }
    }

    @Override
    public SubjectDTO partiallyUpdateSubjectWithId(Long id, Map<String, Object> updates) throws IllegalAccessException {
        Optional<Subject> subject = subjectRepository.findById(id);

        if(subject.isPresent()){
            Subject subjectTOBeUpdated = subject.get();

            Class<?> c1 = subjectTOBeUpdated.getClass();
            Field fields[] = c1.getDeclaredFields();

            for(Field field : fields){
                if(updates.containsKey(field.getName())){
                    field.setAccessible(true);
                    field.set(subjectTOBeUpdated , updates.get(field.getName()));
                }
            }

            return modelMapper.map(subjectRepository.save(subjectTOBeUpdated) , SubjectDTO.class);
        }
        else{
            throw new ResourceNotFoundException("SUBJECT NOT FOUND WITH ID : " + id);
        }
    }
}
