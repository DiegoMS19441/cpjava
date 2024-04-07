package br.com.fiap.cpjava.repository;

import br.com.fiap.cpjava.model.Agricultor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgricultorRepository extends JpaRepository<Agricultor, Long> {
}
