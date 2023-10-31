package com.desafio_profissional.ubs.repositories;

import com.desafio_profissional.ubs.models.domain.Consultas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consultas, Long> {

    Consultas findByMedico_Crm(Long crm);
    Consultas findAllByMedico_Crm(Long crm);
}
