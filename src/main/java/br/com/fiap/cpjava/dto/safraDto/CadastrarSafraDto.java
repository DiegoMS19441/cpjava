package br.com.fiap.cpjava.dto.safraDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record CadastrarSafraDto(

        @NotNull
        @NotBlank
        @Size(min=3)
        String nome,

        @NotNull
        @Past
        LocalDateTime dataInicio,


        @NotNull
        LocalDateTime dataTermino,

        @NotNull
        Integer area
) {
}
