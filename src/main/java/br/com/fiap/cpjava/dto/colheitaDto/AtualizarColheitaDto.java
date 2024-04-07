package br.com.fiap.cpjava.dto.colheitaDto;

import java.time.LocalDateTime;

public record AtualizarColheitaDto(LocalDateTime dataColheita, Integer quantidade, String descricao) {
}
