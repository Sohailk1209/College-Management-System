package com.sohail.controller;

import com.sohail.dto.ProfessorDTO;
import com.sohail.service.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/professor")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @PostMapping(path = "/addProfessor")
    public ProfessorDTO addProfessor(@RequestBody ProfessorDTO professor){
        return professorService.addProfessor(professor);
    }

    @GetMapping(path = "/getAllProfessor")
    public List<ProfessorDTO> getAllProfessor(){
        return professorService.getAllProfessor();
    }

    @GetMapping(path = "/getProfessorById/{id}")
    public ProfessorDTO getProfessorById(@PathVariable Long id){
        return professorService.getProfessorById(id);
    }

    @DeleteMapping(path = "/deleteProfessorWithId/{id}")
    public Boolean deleteProfessorWithId(@PathVariable Long id){
        return professorService.deleteProfessorWithId(id);
    }

    @PutMapping(path = "/updateProfessorById/{id}")
    public ProfessorDTO updateProfessorById(@PathVariable Long id , @RequestBody ProfessorDTO update){
        return professorService.updateProfessorById(id , update);
    }

    @PatchMapping(path = "partiallyUpdateProfessorById/{id}")
    public ProfessorDTO partiallyUpdateProfessorById(@PathVariable Long id , @RequestBody Map<String , Object> updates) throws IllegalAccessException {
        return professorService.partiallyUpdateProfessorById(id , updates);
    }
}
