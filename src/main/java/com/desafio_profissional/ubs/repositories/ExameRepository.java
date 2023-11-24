package com.desafio_profissional.ubs.repositories;

import com.desafio_profissional.ubs.models.domain.Exames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExameRepository extends JpaRepository<Exames, Long> {
    List<Exames> findAllByPacienteCpf(Long cpf);
}
