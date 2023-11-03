package com.desafio_profissional.ubs.models.domain;

import com.desafio_profissional.ubs.enums.ExameEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
@Table(name = "TB_EXAMES")
@Entity
public class Exames {
    @Id
    private Long idExame;
    private LocalDateTime agendaExame;
    private String enderecoLocal;
    private ExameEnum exame;
    @ManyToOne
    private Paciente paciente;


    public Exames(Long idExame, LocalDateTime agendaExame, String enderecoLocal, ExameEnum exame, Paciente paciente) {
        this.idExame = idExame;
        this.agendaExame = agendaExame;
        this.enderecoLocal = enderecoLocal;
        this.exame = exame;
        this.paciente = paciente;
    }

    public Exames() {
    }

    public Long getIdExame() {
        return idExame;
    }

    public void setIdExame(Long idExame) {
        this.idExame = idExame;
    }

    public LocalDateTime getAgendaExame() {
        return agendaExame;
    }

    public void setAgendaExame(LocalDateTime agendaExame) {
        this.agendaExame = agendaExame;
    }

    public String getEnderecoLocal() {
        return enderecoLocal;
    }

    public void setEnderecoLocal(String enderecoLocal) {
        this.enderecoLocal = enderecoLocal;
    }

    public ExameEnum getExame() {
        return exame;
    }

    public void setExame(ExameEnum exame) {
        this.exame = exame;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
