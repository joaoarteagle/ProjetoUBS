package com.desafio_profissional.ubs.models.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table
@Entity
public class Consultas {
    @Id
    private Long idConsulta;
    private LocalDateTime agendaConsulta;
    private String LocalEndereco;

    @ManyToOne
    private Medico medico;
    @ManyToOne
    private Paciente paciente;
    public Consultas(LocalDateTime agendaConsulta, String localEndereco) {
        this.agendaConsulta = agendaConsulta;
        LocalEndereco = localEndereco;
    }

    public Consultas() {

    }
}