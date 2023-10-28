package com.desafio_profissional.ubs.controllers;

import com.desafio_profissional.ubs.dtos.MedicoDto;
import com.desafio_profissional.ubs.models.domain.Consultas;
import com.desafio_profissional.ubs.models.domain.Medico;
import com.desafio_profissional.ubs.repositories.ConsultaRepository;
import com.desafio_profissional.ubs.repositories.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    ConsultaRepository consultaRepository;


    @PostMapping
    public ResponseEntity<Object> post(@RequestBody Medico medicop){
         var medico = new Medico();
        BeanUtils.copyProperties(medicop, medico );

        return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.save(medico));
    }

    @GetMapping
    public ResponseEntity<List<Medico>>getAll(){

        return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.findAll());

    }
    @GetMapping("/{crm}")
    public ResponseEntity<Medico> getOne(@PathVariable Long crm){

        return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.findByCrm(crm));
    }
//    @PutMapping("/{crm}")
//    public ResponseEntity<Medico> update(@PathVariable Long crm){
//
//        return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.)
//    }

    @GetMapping("/consultas/{crm}")
    public ResponseEntity<List<Consultas>> getByCrm(@PathVariable Long crm){

        return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonList(consultaRepository.findAllByMedico_Crm(crm)));
    }
}
