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

}
