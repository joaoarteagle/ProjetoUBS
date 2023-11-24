package com.desafio_profissional.ubs.controllers;

import com.desafio_profissional.ubs.models.domain.Consultas;
import com.desafio_profissional.ubs.repositories.ConsultaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    ConsultaRepository consultaRepository;

    @PostMapping//POST NEW CONSULT IN REPOSITORY
    public ResponseEntity<Consultas> post(@RequestBody Consultas consultap){
        Consultas consulta = new Consultas();
        BeanUtils.copyProperties(consultap, consulta);

        return ResponseEntity.status(HttpStatus.OK).body(consultaRepository.save(consulta));
    }
    @GetMapping// GET ALL CONSULTS IN DATABASE
    public ResponseEntity<List<Consultas>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(consultaRepository.findAll());

    }

        @GetMapping("/{id}") //GET A CONSULT ACCORDING BY ID
    public ResponseEntity<Optional<Consultas>> getOne(@PathVariable @Valid Long id){

        return ResponseEntity.status(HttpStatus.OK).body(consultaRepository.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consultas> alterConsult(@PathVariable  Long id,
                                                  @RequestBody Consultas alter){

        Optional<Consultas> consulta0 = consultaRepository.findById(id);
        var alterCon = consulta0.get();
        BeanUtils.copyProperties(alter,alterCon);
        return ResponseEntity.status(HttpStatus.OK).body(consultaRepository.save(alterCon));
    }


    public ResponseEntity<Object> deleteConsult(@PathVariable Long id){
        Optional<Consultas> consulta0 = consultaRepository.findById(id);

        consultaRepository.delete(consulta0.get());

        return ResponseEntity.status(HttpStatus.OK).body("Consulta deletada com sucesso");
    }

    @GetMapping("/agendaOption")
    public ModelAndView agendarConsulta(){
        ModelAndView view = new ModelAndView("agendaOption");
        return view;
    }

}
