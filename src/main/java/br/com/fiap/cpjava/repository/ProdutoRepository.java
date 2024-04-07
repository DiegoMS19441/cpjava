package br.com.fiap.cpjava.repository;

import br.com.fiap.cpjava.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
