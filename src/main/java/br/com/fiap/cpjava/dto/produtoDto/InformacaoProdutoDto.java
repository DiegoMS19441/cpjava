package br.com.fiap.cpjava.dto.produtoDto;

import br.com.fiap.cpjava.model.InfoPlantacao;
import br.com.fiap.cpjava.model.Produto;

public record InformacaoProdutoDto(String nome, String tipoProduto) {

    public InformacaoProdutoDto(Produto Produto) {
        this(Produto.getNome(), Produto.getTipoProduto());

    }
}
