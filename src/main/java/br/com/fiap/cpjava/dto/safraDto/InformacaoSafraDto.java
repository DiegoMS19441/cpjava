package br.com.fiap.cpjava.dto.safraDto;

import br.com.fiap.cpjava.model.Agricultor;
import br.com.fiap.cpjava.model.Safra;

import java.time.LocalDateTime;

public record InformacaoSafraDto(String nome, LocalDateTime dataInicio,
                                  LocalDateTime dataTermino, Integer area) {

    public InformacaoSafraDto(Safra safra){
        this(safra.getNome(),safra.getDataInicio(),safra.getDataTermino(),safra.getArea());
    }
}
