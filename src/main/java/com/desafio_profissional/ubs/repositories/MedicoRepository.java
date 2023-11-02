package com.desafio_profissional.ubs.repositories;

import com.desafio_profissional.ubs.models.domain.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
     Medico findByCrm(Long crm);
     Medico deleteByCrm(Long crm);
}
