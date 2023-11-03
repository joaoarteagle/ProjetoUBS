package com.desafio_profissional.ubs.repositories;

import com.desafio_profissional.ubs.models.domain.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
}
