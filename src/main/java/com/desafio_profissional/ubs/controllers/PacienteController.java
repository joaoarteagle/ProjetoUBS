package com.desafio_profissional.ubs.controllers;

import com.desafio_profissional.ubs.dtos.PacienteDto;
import com.desafio_profissional.ubs.models.domain.Paciente;
import com.desafio_profissional.ubs.repositories.PacientesRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    PacientesRepository pacientesRepository;
    @PostMapping
    public ResponseEntity<Paciente> post(@RequestBody Paciente paciente){
        var paciente0 = new Paciente();
        BeanUtils.copyProperties(paciente, paciente0);
        return ResponseEntity.status(HttpStatus.OK).body(pacientesRepository.save(paciente0));
    }



    //LOGIN POR CPF
    @GetMapping("/menu")
    public ModelAndView cadastrarPessoa(){
        ModelAndView view = new ModelAndView("menu");
        return view;
    }

    @GetMapping("/login")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView("index");
        return view;
    }



    // NÃO POSSUI CONTA
    @GetMapping("/cadastro1")
    public ModelAndView cadastro1(){
        ModelAndView cadastro1 = new ModelAndView("cadastro1");
        return cadastro1;
    }

    @GetMapping("/cadastro2")
    public ModelAndView cadastro2(){
        ModelAndView cadastro2 = new ModelAndView("cadastro2");
        return cadastro2;
    }

    @GetMapping("/cadastro3")
    public ModelAndView cadastro3(){
        ModelAndView cadastro3 = new ModelAndView("cadastro3");
        return cadastro3;
    }

}
