package br.com.fiap.cpjava.dto.colheitaDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

import java.time.LocalDateTime;

public record CadastrarColheitaDto(

        @Past@NotNull
        LocalDateTime dataColheita,

        @NotNull
        Integer quantidade,

        @NotNull@NotBlank
        String descricaoColheita) {
}
