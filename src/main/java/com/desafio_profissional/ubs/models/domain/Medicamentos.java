package com.desafio_profissional.ubs.models.domain;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "TB_MEDICAMENTOS")
@Entity
public class Medicamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMedicamento;
    private String nomeMedicamento;
    private String descricao;

    @ManyToMany(mappedBy = "medicamentos")
    private List<Receita> receitas;


    public Medicamentos(Long idMedicamento, String nomeMedicamento, String descricao) {
        this.idMedicamento = idMedicamento;
        this.nomeMedicamento = nomeMedicamento;
        this.descricao = descricao;
    }

    public Medicamentos(){

    }



    public Long getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Long idMedicamento) {
        this.idMedicamento = idMedicamento;
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
