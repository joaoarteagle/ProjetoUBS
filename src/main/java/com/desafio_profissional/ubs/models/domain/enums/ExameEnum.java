package com.desafio_profissional.ubs.models.domain.enums;

public enum ExameEnum {
    EXAMES_DE_SANGUE("Exame de Sangue"),
    EXAMES_DE_IMAGEM("Exame de Imagem"),
    TOMOGRAFIA_COMPUTADORIZADA("Tomografia"),
    RESSONANCIA_MAGNETICA("Ressonancia Magnetica"),
    MAMOGRAFIA("Mamografia"),
    COLONOSCOPIA("Colonoscopia"),
    ENDOSCOPIA("Endoscopia"),
    ELETROCARDIOGRAMA("Eletrocardiograma"),
    ECOCARDIOGRAMA("Ecocardiograma"),
    TESTES_DE_FUNCAO_PULMONAR("Teste de Função Pulmonar"),
    EXAMES_DE_AUDIOMETRIA("Exame de Audiometria"),
    EXAMES_DE_OFTALMOLOGIA("Exame de Oftalmologia"),
    EXAMES_DE_DENSITOMETRIA_OSSEA("Exame de Densitometria Ossea"),
    TESTES_DE_HIV("Teste de HIV"),
    EXAMES_PARA_DIAGNOSTICO_DE_DSTS("Diagnostico de DSTs"),
    EXAMES_PARA_DIAGNOSTICO_DE_HEPATITES("Diagnostico de Hepatite"),
    EXAMES_DE_LABORATORIO_PARA_DIAGNOSTICO_DE_CANCER("Diagnostico de Câncer"),
    EXAMES_DE_URINA_E_FEZES("Exame de Urina e Fezes"),
    EXAMES_DE_CITOLOGIA_CERVICAL("Citologia Cervical"),
    EXAMES_PARA_CONTROLE_DE_DOENCAS_CRONICAS("Controle de Doenças Crônicas");

    ExameEnum(String nome) {

        this.nome = nome;
    }
    private final String nome;

    @Override
    public String toString() {
        return nome;
    }
}
