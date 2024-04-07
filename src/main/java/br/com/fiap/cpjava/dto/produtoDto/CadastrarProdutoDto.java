package br.com.fiap.cpjava.dto.produtoDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CadastrarProdutoDto(

        @NotNull
        @Size(min = 3)
        @NotBlank
        String nome,

        @NotNull
        @Size(min=5)
        String tipoProduto) {
}
