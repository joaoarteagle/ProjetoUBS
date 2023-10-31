package com.desafio_profissional.ubs.controllers;

import com.desafio_profissional.ubs.models.domain.Pessoa;
import com.desafio_profissional.ubs.repositories.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaRepository pessoaRepository;

    @PostMapping
    public ResponseEntity<Pessoa> savePessoa(@RequestBody Pessoa pessoa){
        var pessoa0 = new Pessoa();
        BeanUtils.copyProperties(pessoa, pessoa0);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaRepository.save(pessoa0));
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> getAllPessoa(){
        List<Pessoa> pessoaList = pessoaRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(pessoaList);
    }
    @GetMapping("/{cpf}")
    public ResponseEntity<Pessoa> getOnePessoa(@PathVariable Long cpf){

        Optional<Pessoa> person0 = pessoaRepository.findById(cpf);

        return ResponseEntity.status(HttpStatus.OK).body(person0.get());

    }
    @PutMapping("/{cpf}")
    public ResponseEntity<Pessoa> altualizarDados(@PathVariable Long cpf,
                                                  @RequestBody Pessoa pessoa){

        Optional<Pessoa> person = pessoaRepository.findById(cpf);

        var person0 = person.get();
        BeanUtils.copyProperties(person, pessoa);

        return ResponseEntity.status(HttpStatus.OK).body(pessoaRepository.save(person0));
    }
    @DeleteMapping("/{cpf}")
    public ResponseEntity<Object> deletarPessoa(@PathVariable Long cpf){
        Optional<Pessoa> pessoa = pessoaRepository.findById(cpf);
        pessoaRepository.delete(pessoa.get());

        return ResponseEntity.status(HttpStatus.OK).body("Cadastro deletado com sucesso");
    }
}
