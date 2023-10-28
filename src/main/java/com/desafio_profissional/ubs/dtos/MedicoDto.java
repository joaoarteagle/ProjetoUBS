package com.desafio_profissional.ubs.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record MedicoDto(@NotNull Long crm, @NotEmpty String nomeCompleto) {
}
