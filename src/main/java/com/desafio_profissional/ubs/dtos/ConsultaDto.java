package com.desafio_profissional.ubs.dtos;

import com.desafio_profissional.ubs.models.domain.Medico;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ConsultaDto(@NotNull LocalDateTime agendaConsulta) {
}
