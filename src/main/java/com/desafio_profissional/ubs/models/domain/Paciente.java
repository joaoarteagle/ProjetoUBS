package com.desafio_profissional.ubs.models.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table(name = "TB_PACIENTE")
@Entity
public class Paciente extends Pessoa{
    private String convenio;
    private String contatoEmergencia;

    public Paciente(String convenio, String contatoEmergencia) {
        this.convenio = convenio;
        this.contatoEmergencia = contatoEmergencia;
    }

    public Paciente() {

    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public String getContatoEmergencia() {
        return contatoEmergencia;
    }

    public void setContatoEmergencia(String contatoEmergencia) {
        this.contatoEmergencia = contatoEmergencia;
    }
}
