package com.sohail.service.impl;

import com.sohail.dto.StudentDTO;
import com.sohail.entity.Student;
import com.sohail.exception.ResourceNotFoundException;
import com.sohail.repository.StudentRepository;
import com.sohail.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final ModelMapper modelMapper;
    private final StudentRepository studentRepository;


    @Override
    public List<StudentDTO> getAllStudent() {
        return studentRepository.findAll()
                .stream()
                .map(student -> modelMapper.map(student , StudentDTO.class))
                .toList();
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);

        if(student.isPresent()){
            return modelMapper.map(student.get() , StudentDTO.class);
        }
        else{
            throw new ResourceNotFoundException("STUDENT NOT FOUND WITH ID : " + id);
        }
    }

    @Override
    public StudentDTO updateStudentById(Long id, StudentDTO update) {
        Optional<Student> student = studentRepository.findById(id);

        if(student.isPresent()){
            Student studentToBeUpdated = student.get();
            studentToBeUpdated = modelMapper.map(update , Student.class);
            studentToBeUpdated.setId(id);

            Student savedStudent = studentRepository.save(studentToBeUpdated);
            return modelMapper.map(savedStudent , StudentDTO.class);
        }
        else{
            throw new ResourceNotFoundException("STUDENT NOT FOUND WITH ID : " + id);
        }
    }

    @Override
    public StudentDTO partiallyUpdateStudentById(Long id, Map<String, Object> updates) throws IllegalAccessException {
        Optional<Student> student = studentRepository.findById(id);

        if(student.isPresent()){
            Student studentToBeUpdated = student.get();

            Class<?> c1 = studentToBeUpdated.getClass();
            Field fields[] = c1.getDeclaredFields();

            for(Field field : fields){
                if(updates.containsKey(field.getName())){
                    field.setAccessible(true);
                    field.set(studentToBeUpdated , updates.get(field.getName()));
                }
            }

            Student savedStudent = studentRepository.save(studentToBeUpdated);
            return modelMapper.map(savedStudent , StudentDTO.class);
        }
        else{
            throw new ResourceNotFoundException("STUDENT NOT FOUND WITH ID : " + id);
        }
    }
}
