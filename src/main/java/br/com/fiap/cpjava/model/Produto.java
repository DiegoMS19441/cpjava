package br.com.fiap.cpjava.model;

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

    @Column(name="tb_produto")
    private String tipoProduto;

    public Produto(CadastroProdutoDto produtoDto) {
        id = infoPlantacaoDto.id();
        nome = infoPlantacaoDto.nome();
        tipoProduto = infoPlantacaoDto.tipoProduto();
    }

}
