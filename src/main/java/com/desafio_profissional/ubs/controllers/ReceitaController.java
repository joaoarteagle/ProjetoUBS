package com.desafio_profissional.ubs.controllers;

import com.desafio_profissional.ubs.models.domain.Receita;
import com.desafio_profissional.ubs.repositories.ReceitaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/receitas")
public class ReceitaController {


    @Autowired
    ReceitaRepository receitaRepository;
    @PostMapping
    public ResponseEntity<Receita> saveReceita(@RequestBody Receita receita){
        Receita receita1 = new Receita();
        BeanUtils.copyProperties(receita, receita1);

        return ResponseEntity.status(HttpStatus.OK).body(receitaRepository.save(receita1));
    }
    @GetMapping
    public ResponseEntity<List<Receita>> getAllReceitas(){
        List<Receita> receitas = receitaRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(receitas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Receita> getOneReceita(@PathVariable Long id){

        Optional<Receita> receita = receitaRepository.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(receita.get());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Receita> deleteReceita(@PathVariable Long id){
    receitaRepository.deleteById(id);

    return (ResponseEntity<Receita>) ResponseEntity.ok();
    }
}
