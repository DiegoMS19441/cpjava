package br.com.fiap.cpjava.repository;

import br.com.fiap.cpjava.model.Colheita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface ColheitaRepository extends JpaRepository<Colheita, LocalDate> {
}
