package com.desafio_profissional.ubs.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record MedicamentoDto(@NotNull @NotEmpty String nomeMedicamento,
                             @NotNull @NotEmpty String descricao) {
}
