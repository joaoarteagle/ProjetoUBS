package com.desafio_profissional.ubs.models.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Table(name = "TB_PACIENTE")
@Entity
public class Paciente extends Pessoa{

    private Long cpf;
    private String convenio;
    private String contatoEmergencia;
    @OneToMany(mappedBy = "paciente")
    private List<Exames> exames;
    @OneToMany(mappedBy = "paciente")
    private List<Consultas> consultas;

    public Paciente(Long cpf,String convenio, String contatoEmergencia) {
        super();
        this.convenio = convenio;
        this.contatoEmergencia = contatoEmergencia;
    }

    public Paciente() {

        super();
    }

    @Override
    public Long getCpf() {
        return cpf;
    }

    @Override
    public void setCpf(Long cpf) {
        this.cpf = cpf;
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
