package br.com.fiap.cpjava.dto.fazendaDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CadastrarFazendaDto(
        @NotNull
        @Size(max = 14, min = 14)
        String cnpj,

        @NotBlank
        @Size(max = 100, min = 10)
        String nome,

        @NotNull
        @NotBlank
        @Size(max = 100)
        String endereco,

        @Size(max = 8, min = 8)
        @NotNull
        String cep,

        @NotNull
        @NotBlank
        @Email
        String email,

        @NotNull
        @Size(max = 9, min = 9)
        String telefone,

        @NotNull
        Integer hectares) {
}
