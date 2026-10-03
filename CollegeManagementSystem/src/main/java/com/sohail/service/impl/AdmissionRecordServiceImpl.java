package com.sohail.service.impl;

import com.sohail.dto.AdmissionRecordDTO;
import com.sohail.entity.AdmissionRecord;
import com.sohail.exception.ResourceNotFoundException;
import com.sohail.repository.AdmissionRecordRepository;
import com.sohail.service.AdmissionRecordService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdmissionRecordServiceImpl implements AdmissionRecordService {

    private final ModelMapper modelMapper;
    private final AdmissionRecordRepository admissionRecordRepository;

    @Override
    @Transactional
    public AdmissionRecordDTO createNewRecord(AdmissionRecordDTO record) {
        AdmissionRecord recordToBeSaved = modelMapper.map(record , AdmissionRecord.class);
        AdmissionRecord savedRecord = admissionRecordRepository.save(recordToBeSaved);
        return modelMapper.map(savedRecord , AdmissionRecordDTO.class);
    }

    @Override
    public List<AdmissionRecordDTO> getAllAdmissionRecord() {
        return admissionRecordRepository.findAll()
                .stream()
                .map(admissionRecord -> modelMapper.map(admissionRecord , AdmissionRecordDTO.class))
                .toList();
    }

    @Override
    public AdmissionRecordDTO getAdmissionRecordByID(Long id) {
        Optional<AdmissionRecord> admissionRecord = admissionRecordRepository.findById(id);

        if(admissionRecord.isPresent()){
            return modelMapper.map(admissionRecord.get() , AdmissionRecordDTO.class);
        }
        else{
            throw new ResourceNotFoundException("ADMISSION RECORD NOT FOUND WITH ID : " + id);
        }
    }

    @Override
    public Boolean deleteAdmissionRecordWithId(Long id) {
        Optional<AdmissionRecord> admissionRecord = admissionRecordRepository.findById(id);

        if(admissionRecord.isPresent()){
            admissionRecordRepository.deleteById(id);
            return true;
        }
        else{
            throw new ResourceNotFoundException("ADMISSION RECORD NOT FOUND WITH ID : " + id);
        }
    }

    @Override
    public AdmissionRecordDTO updateAdmissionRecordWithId(Long id, AdmissionRecordDTO update) {
        Optional<AdmissionRecord> admissionRecord = admissionRecordRepository.findById(id);

        if(admissionRecord.isPresent()){
            AdmissionRecord recordToBeUpdated = admissionRecord.get();
            Long studentId = recordToBeUpdated.getStudent().getId();
            recordToBeUpdated = modelMapper.map(update , AdmissionRecord.class);
            recordToBeUpdated.setId(id);
            recordToBeUpdated.getStudent().setId(studentId);

            AdmissionRecord updatedRecord = admissionRecordRepository.save(recordToBeUpdated);
            return modelMapper.map(updatedRecord , AdmissionRecordDTO.class);
        }
        else{
            throw new ResourceNotFoundException("ADMISSION RECORD NOT FOUND WITH ID : " + id);
        }
    }

    @Override
    public AdmissionRecordDTO partiallyUpdateAdmissionRecordWithId(Long id, Map<String, Object> updates) throws IllegalAccessException {
        Optional<AdmissionRecord> admissionRecord = admissionRecordRepository.findById(id);

        if(admissionRecord.isPresent()){
            AdmissionRecord admissionRecordToBeUpdated = admissionRecord.get();
            Long studentId = admissionRecordToBeUpdated.getStudent().getId();

            Class<?> admissionRecordClass = admissionRecordToBeUpdated.getClass();
            Field[] fields =  admissionRecordClass.getDeclaredFields();

            for(Field field : fields){
                if(updates.containsKey(field.getName())){
                    field.setAccessible(true);
                    Object value = updates.get(field.getName());

                    if(value instanceof Map<?,?>){
                        value = modelMapper.map(value , field.getType());
                    }

                    field.set(admissionRecordToBeUpdated , value);
                }
            }

            admissionRecordToBeUpdated.getStudent().setId(studentId);
            AdmissionRecord savedRecord = admissionRecordRepository.save(admissionRecordToBeUpdated);

            return modelMapper.map(savedRecord , AdmissionRecordDTO.class);
        }
        else{
            throw new ResourceNotFoundException("ADMISSION RECORD NOT FOUND WITH ID : " + id);
        }
    }
}
