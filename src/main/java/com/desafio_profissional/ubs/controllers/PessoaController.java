package com.desafio_profissional.ubs.controllers;

import com.desafio_profissional.ubs.models.domain.Pessoa;
import com.desafio_profissional.ubs.repositories.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaRepository pessoaRepository;


    public ResponseEntity<Pessoa> savePessoa(@RequestBody Pessoa pessoa){
        var pessoa0 = new Pessoa();
        BeanUtils.copyProperties(pessoa, pessoa0);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaRepository.save(pessoa0));
    }


}
