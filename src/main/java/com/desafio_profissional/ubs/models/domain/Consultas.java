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

    public Long getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Long idConsulta) {
        this.idConsulta = idConsulta;
    }

    public LocalDateTime getAgendaConsulta() {
        return agendaConsulta;
    }

    public void setAgendaConsulta(LocalDateTime agendaConsulta) {
        this.agendaConsulta = agendaConsulta;
    }

    public String getLocalEndereco() {
        return LocalEndereco;
    }

    public void setLocalEndereco(String localEndereco) {
        LocalEndereco = localEndereco;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}