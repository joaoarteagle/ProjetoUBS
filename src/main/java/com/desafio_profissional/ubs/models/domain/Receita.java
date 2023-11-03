package com.desafio_profissional.ubs.models.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_RECEITAS")
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReceita;

    @ManyToOne
    @JoinColumn(name = "paciente_cpf")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_crm")
    private Medico medico;

    @ManyToMany
    @JoinTable(name = "receita_medicamento",
    joinColumns = @JoinColumn(name = "Receita_id"),
    inverseJoinColumns = @JoinColumn(name = "medicamento_id"))
    private List<Medicamentos> medicamentos;

    public Receita(Long idReceita, Paciente paciente, Medico medico, List<Medicamentos> medicamentos) {
        this.idReceita = idReceita;
        this.paciente = paciente;
        this.medico = medico;
        this.medicamentos = medicamentos;
    }

    public Receita() {
    }

    public Long getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(Long idReceita) {
        this.idReceita = idReceita;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<Medicamentos> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamentos> medicamentos) {
        this.medicamentos = medicamentos;
    }
}
