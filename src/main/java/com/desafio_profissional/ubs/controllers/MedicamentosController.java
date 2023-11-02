package com.desafio_profissional.ubs.controllers;

import com.desafio_profissional.ubs.dtos.MedicamentoDto;
import com.desafio_profissional.ubs.models.domain.Medicamentos;
import com.desafio_profissional.ubs.repositories.MedicamentosRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentosController {

    @Autowired
    MedicamentosRepository medicamentosRepository;
    @PostMapping
    public ResponseEntity<Medicamentos> postMedicamento(@RequestBody @Valid MedicamentoDto medicamento){
        var medicamento0 = new Medicamentos();
        BeanUtils.copyProperties(medicamento, medicamento0);
        return ResponseEntity.status(HttpStatus.OK).body(medicamentosRepository.save(medicamento0));
    }
    @GetMapping
    public ResponseEntity<List<Medicamentos>> getAllMedicamentos(){
        List<Medicamentos> medicamentosList = medicamentosRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(medicamentosList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Medicamentos> getOneMedicamento(@PathVariable Long id){
        Optional<Medicamentos> medicamento = medicamentosRepository.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(medicamento.get());

    }
}
