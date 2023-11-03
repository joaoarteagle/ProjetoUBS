package com.desafio_profissional.ubs.dtos;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

public record PacienteDto(@NotNull String nomeCompleto,@NotNull @CPF Long cpf) {
}
