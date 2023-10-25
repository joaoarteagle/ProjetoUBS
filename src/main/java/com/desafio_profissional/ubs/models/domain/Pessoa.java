package com.desafio_profissional.ubs.models.domain;

import com.desafio_profissional.ubs.enums.EstadoCivil;
import com.desafio_profissional.ubs.enums.Estados;
import com.desafio_profissional.ubs.enums.Nascionalidade;
import com.desafio_profissional.ubs.enums.Sexo;
import jakarta.persistence.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "TB_PESSOA")
public class Pessoa extends RepresentationModel<Pessoa> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @CPF
    @Id
    private Long cpf;
    private String nomeCompleto;
    private Date dataNasc;
    private String registroGeral;
    private Sexo sexo;
    private String telefone;
    private EstadoCivil estadoCivil;
    private Nascionalidade nascionalidade;
    private String endereco;
    private String cep;
    private Estados estado;
    private String email;

    public Pessoa() {
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.dataNasc = dataNasc;
        this.registroGeral = registroGeral;
        this.sexo = sexo;
        this.telefone = telefone;
        this.estadoCivil = estadoCivil;
        this.nascionalidade = nascionalidade;
        this.endereco = endereco;
        this.cep = cep;
        this.estado = estado;
        this.email = email;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getRegistroGeral() {
        return registroGeral;
    }

    public void setRegistroGeral(String registroGeral) {
        this.registroGeral = registroGeral;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Nascionalidade getNascionalidade() {
        return nascionalidade;
    }

    public void setNascionalidade(Nascionalidade nascionalidade) {
        this.nascionalidade = nascionalidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Estados getEstado() {
        return estado;
    }

    public void setEstado(Estados estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
