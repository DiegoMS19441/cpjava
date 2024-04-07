package br.com.fiap.cpjava.dto.colheitaDto;

import br.com.fiap.cpjava.model.Colheita;

import java.time.LocalDateTime;

public record ListagemColheitaDto(Long codigo, LocalDateTime dataColheita,
                                  Integer quantidade, String descricaoColheita) {

    public ListagemColheitaDto(Colheita colheita){
        this(colheita.getId(), colheita.getDataColheita(),
                colheita.getQuantidade(), colheita.getDescricaoColheita());
    }

}
