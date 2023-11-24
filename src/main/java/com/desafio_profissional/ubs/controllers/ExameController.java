package com.desafio_profissional.ubs.controllers;

import com.desafio_profissional.ubs.models.domain.Exames;
import com.desafio_profissional.ubs.models.domain.Medicamentos;
import com.desafio_profissional.ubs.repositories.ExameRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exames")
public class ExameController {

    @Autowired
    ExameRepository exameRepository;
    @PostMapping
    public ResponseEntity<Exames> saveExam(@RequestBody Exames exame){
        Exames exames0 = new Exames();

        BeanUtils.copyProperties(exame,exames0);
        return ResponseEntity.status(HttpStatus.OK).body(exameRepository.save(exames0));
    }
    @GetMapping("/get")
    public ModelAndView getAllbyCPF(){
        List<Exames> examesList = exameRepository.findAll();
        ModelAndView view = new ModelAndView("exames");
        view.addObject("exames",examesList);

        return view;
    }
//    @GetMapping
//    public ResponseEntity<List<Exames>> getAllExam(){
//        return ResponseEntity.status(HttpStatus.OK).body(exameRepository.findAll());
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<Exames> getOneExam(@PathVariable Long id){
//        var exame = exameRepository.findById(id);
//
//        return ResponseEntity.status(HttpStatus.OK).body(exame.get());
//    }
    @PutMapping("/{id}")
    public ResponseEntity<Exames> updateExame(@PathVariable Long id,
                                              @RequestBody Exames exame){

        var exame0 = new Exames();
        BeanUtils.copyProperties(exame, exame0);
        Optional<Exames> alterExam = exameRepository.findById(id);

        BeanUtils.copyProperties(exame0, alterExam.get());

        return ResponseEntity.status(HttpStatus.OK).body(exameRepository.save(alterExam.get()));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delExam(@PathVariable Long id){

        exameRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Exame Deletado com sucesso");
    }
}
