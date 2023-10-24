package com.desafio_profissional.ubs.models.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "TB_MEDICAMENTOS")
@Entity
public class Medicamentos {
    @Id
    private Long idMedicamento;
    private String nomeMedicamento;
    private String descricao;
}
