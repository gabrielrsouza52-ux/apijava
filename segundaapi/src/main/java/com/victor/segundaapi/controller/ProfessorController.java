package com.victor.segundaapi.controller;

import com.victor.segundaapi.model.ProfessorModel;
import com.victor.segundaapi.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/professor")
@CrossOrigin(value = "*")
public class ProfessorController {

    @Autowired
    ProfessorRepository professorRepository;

    @GetMapping(value = "/listar")
    public ResponseEntity<List<ProfessorModel>> listarProfessores() {
        List<ProfessorModel> lista = professorRepository.findAll();
        return ResponseEntity.ok().body(lista);
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<ProfessorModel> cadastrarProfessor(@RequestBody ProfessorModel professor) {
        ProfessorModel professorSalvo = professorRepository.save(professor);
        return ResponseEntity.status(HttpStatus.CREATED).body(professorSalvo);
    }

}
