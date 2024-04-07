package br.com.fiap.cpjava.repository;

import br.com.fiap.cpjava.model.Fazenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FazendaRepository extends JpaRepository<Fazenda, Long> {
}

