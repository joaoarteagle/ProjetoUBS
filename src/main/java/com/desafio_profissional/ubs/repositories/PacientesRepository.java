package com.desafio_profissional.ubs.repositories;

import com.desafio_profissional.ubs.models.domain.Paciente;
import com.desafio_profissional.ubs.models.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacientesRepository extends JpaRepository<Paciente, Long> {
}
