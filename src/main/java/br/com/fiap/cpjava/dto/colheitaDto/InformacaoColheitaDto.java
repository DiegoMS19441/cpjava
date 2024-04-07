package br.com.fiap.cpjava.dto.colheitaDto;

import br.com.fiap.cpjava.model.Agricultor;
import br.com.fiap.cpjava.model.Colheita;

import java.time.LocalDateTime;

public record InformacaoColheitaDto(Long codigo, LocalDateTime dataColheita, Integer quantidade, String descricaoColheita) {

    public InformacaoColheitaDto(Colheita colheita){
        this(colheita.getId(), colheita.getDataColheita(),
                colheita.getQuantidade(), colheita.getDescricaoColheita());
    }
}
