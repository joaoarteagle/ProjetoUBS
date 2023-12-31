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
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentosController {

    @Autowired
    MedicamentosRepository medicamentosRepository;
    @PostMapping
    public ResponseEntity<Object> postMedicamento(@RequestBody @Valid MedicamentoDto medicamento){
        Medicamentos medicamento0 = new Medicamentos();
       BeanUtils.copyProperties(medicamento,medicamento0);
        return ResponseEntity.status(HttpStatus.OK).body(medicamentosRepository.save(medicamento0));
    }
    @GetMapping
    public ModelAndView getAllMedicamentos(){
        List<Medicamentos> medicamentosList = medicamentosRepository.findAll();
        ModelAndView view = new ModelAndView("medicamento");
        view.addObject("medicamentos",medicamentosList);
        return view;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Medicamentos> getOneMedicamento(@PathVariable Long id){
        Optional<Medicamentos> medicamento = medicamentosRepository.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(medicamento.get());

    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicamentos> updateMedicamento(@PathVariable Long id, @RequestBody MedicamentoDto dto){
        Optional<Medicamentos> medicamento = medicamentosRepository.findById(id);
        Medicamentos medicamento0 = medicamento.get();
        BeanUtils.copyProperties(dto, medicamento0);

        return ResponseEntity.status(HttpStatus.OK).body(medicamentosRepository.save(medicamento0));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMedicamento(@PathVariable Long id){
        medicamentosRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("deletado com sucesso");
    }

}
