package com.desafio_profissional.ubs.models.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Table(name = "TB_MEDICO")
@Entity
public class Medico extends Pessoa{
    private Long crm;
    @OneToMany(mappedBy = "medico")
    private List<Consultas> consultasList;


    public Medico() {
        super();
    }
}
