package com.desafio_profissional.ubs.models.domain;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "TB_MEDICAMENTOS")
@Entity
public class Medicamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idMedicamento;
    private String nomeMedicamento;
    private String descricao;

    @ManyToMany(mappedBy = "medicamentos")
    private List<Receita> receitas;


    public Medicamentos(String nomeMedicamento, String descricao) {
        this.nomeMedicamento = nomeMedicamento;
        this.descricao = descricao;
    }
    public Medicamentos(){

    }

    public List<Receita> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }

    public String getNomeMedicamento() {
        return nomeMedicamento;
    }

    public void setNomeMedicamento(String nomeMedicamento) {
        this.nomeMedicamento = nomeMedicamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
