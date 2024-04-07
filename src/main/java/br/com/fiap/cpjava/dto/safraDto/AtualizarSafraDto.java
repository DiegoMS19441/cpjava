package br.com.fiap.cpjava.dto.safraDto;

import java.time.LocalDateTime;

public record AtualizarSafraDto(String nome, LocalDateTime dataInicio,
                                LocalDateTime dataTermino, Integer area) {
}
