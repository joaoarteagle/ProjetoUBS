package com.desafio_profissional.ubs.controllers;

import com.desafio_profissional.ubs.models.domain.Consultas;
import com.desafio_profissional.ubs.models.domain.Medico;
import com.desafio_profissional.ubs.repositories.ConsultaRepository;
import com.desafio_profissional.ubs.repositories.MedicoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    ConsultaRepository consultaRepository;


    @PostMapping
    public ResponseEntity<Object> postNewMedico(@RequestBody Medico medicop){
         var medico = new Medico();
        BeanUtils.copyProperties(medicop, medico );

        return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.save(medico));
    }

    @GetMapping
    public ResponseEntity<List<Medico>>getAllMedicos(){

        return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.findAll());

    }
    @GetMapping("/{crm}")
    public ResponseEntity<Medico> getOneMedico(@PathVariable Long crm){

        return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.findByCrm(crm));
    }
    @PutMapping("/{crm}")
    public ResponseEntity<Medico> updateMedico(@PathVariable Long crm,
                                         @RequestBody Medico medico){
       Optional<Medico> medico1 = Optional.ofNullable(medicoRepository.findByCrm(crm));
        var alterMedico = medico1.get();
        BeanUtils.copyProperties(medico, alterMedico);
        return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.save(alterMedico));
    }

    @DeleteMapping("/{crm}")
    public ResponseEntity<Object> deleteMedico(@PathVariable Long crm){
        Medico medico = medicoRepository.findByCrm(crm);

        medicoRepository.deleteByCrm(crm);
        return ResponseEntity.status(HttpStatus.OK).body("Medico deletado com sucesso");
    }
    @GetMapping("/{crm}/consultas")
    public ResponseEntity<List<Consultas>> getByCrm(@PathVariable Long crm){

        return ResponseEntity.status(HttpStatus.OK).body(Collections.singletonList(consultaRepository.findAllByMedico_Crm(crm)));
    }
}
