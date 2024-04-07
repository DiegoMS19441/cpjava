package br.com.fiap.cpjava.model;

import br.com.fiap.cpjava.dto.produtoDto.AtualizarProdutoDto;
import br.com.fiap.cpjava.dto.produtoDto.CadastrarProdutoDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor

@Entity
@Table(name="TB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue
    @Column(name="id_Produto")
    private Long id;

    @Column(name="nm_produto", length = 30, nullable = false)
    private String nome;

    @Column(name="tp_produto")
    private String tipoProduto;

    public Produto(CadastrarProdutoDto produtoDto) {
        nome = produtoDto.nome();
        tipoProduto = produtoDto.tipoProduto();
    }
    public void atualizarProduto(AtualizarProdutoDto dto){
        if (dto.nome() != null)
            nome = dto.nome();
        if (dto.tipoProduto() != null)
            tipoProduto = dto.tipoProduto();
    }

}
