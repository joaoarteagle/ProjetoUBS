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

    public Medico(Long crm, List<Consultas> consultasList) {
        this.crm = crm;
        this.consultasList = consultasList;
    }

    public Long getCrm() {
        return crm;
    }

    public void setCrm(Long crm) {
        this.crm = crm;
    }

    public List<Consultas> getConsultasList() {
        return consultasList;
    }

    public void setConsultasList(List<Consultas> consultasList) {
        this.consultasList = consultasList;
    }
}
