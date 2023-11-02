package com.desafio_profissional.ubs.models.domain;

import jakarta.persistence.*;

@Table(name = "TB_MEDICAMENTOS")
@Entity
public class Medicamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idMedicamento;
    private String nomeMedicamento;
    private String descricao;
}
