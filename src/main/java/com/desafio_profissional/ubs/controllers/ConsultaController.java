package com.desafio_profissional.ubs.controllers;

import com.desafio_profissional.ubs.models.domain.Consultas;
import com.desafio_profissional.ubs.repositories.ConsultaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping
    public ResponseEntity<List<Consultas>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(consultaRepository.findAll());

    }

        @GetMapping("/{id}")
    public ResponseEntity<Optional<Consultas>> getOne(@PathVariable @Valid Long id){

        return ResponseEntity.status(HttpStatus.OK).body(consultaRepository.findById(id));
    }
}
