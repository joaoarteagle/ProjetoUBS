package com.desafio_profissional.ubs.dtos;

import jakarta.validation.constraints.NotNull;

public record PacienteDto(NotNull nomeCompleto, NotNull cpf) {
}
