package br.com.fiap.cpjava.dto.produtoDto;

import br.com.fiap.cpjava.model.Produto;

public record ListagemProdutoDto(String nome, String tipoProduto) {

    public ListagemProdutoDto(Produto Produto) {
        this(Produto.getNome(), Produto.getTipoProduto());

    }
}
