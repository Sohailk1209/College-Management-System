package com.sohail.controller;

import com.sohail.dto.AdmissionRecordDTO;
import com.sohail.service.AdmissionRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/admissionRecord")
public class AdmissionRecordController {

    private final AdmissionRecordService admissionRecordService;

    @PostMapping(path = "/createNewRecord")
    private AdmissionRecordDTO createNewRecord(@RequestBody AdmissionRecordDTO record){
        return admissionRecordService.createNewRecord(record);
    }

    @GetMapping(path = "/getAllAdmissionRecord")
    public List<AdmissionRecordDTO> getAllAdmissionRecord(){
        return admissionRecordService.getAllAdmissionRecord();
    }

    @GetMapping(path = "/getAdmissionRecordByID/{id}")
    public AdmissionRecordDTO getAdmissionRecordByID(@PathVariable Long id){
        return admissionRecordService.getAdmissionRecordByID(id);
    }

    @DeleteMapping(path = "/deleteAdmissionRecordWithId/{id}")
    public Boolean deleteAdmissionRecordWithId(@PathVariable Long id){
        return admissionRecordService.deleteAdmissionRecordWithId(id);
    }

    @PutMapping(path = "/updateAdmissionRecordWithId/{id}")
    public AdmissionRecordDTO updateAdmissionRecordWithId(@PathVariable Long id , @RequestBody AdmissionRecordDTO update){
        return admissionRecordService.updateAdmissionRecordWithId(id , update);
    }

    @PatchMapping(path = "/partiallyUpdateAdmissionRecordWithId/{id}")
    public AdmissionRecordDTO partiallyUpdateAdmissionRecordWithId(@PathVariable Long id , @RequestBody Map<String , Object> updates) throws IllegalAccessException {
        return admissionRecordService.partiallyUpdateAdmissionRecordWithId(id , updates);
    }
}
