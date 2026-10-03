package com.sohail.service;

import com.sohail.dto.AdmissionRecordDTO;

import java.util.List;
import java.util.Map;

public interface AdmissionRecordService {
    AdmissionRecordDTO createNewRecord(AdmissionRecordDTO record);

    List<AdmissionRecordDTO> getAllAdmissionRecord();

    AdmissionRecordDTO getAdmissionRecordByID(Long id);

    Boolean deleteAdmissionRecordWithId(Long id);

    AdmissionRecordDTO updateAdmissionRecordWithId(Long id, AdmissionRecordDTO update);

    AdmissionRecordDTO partiallyUpdateAdmissionRecordWithId(Long id, Map<String, Object> updates) throws IllegalAccessException;
}
