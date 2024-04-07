package br.com.fiap.cpjava.dto.safraDto;

import br.com.fiap.cpjava.model.Safra;

import java.time.LocalDateTime;

public record ListagemSafraDto(String nome, LocalDateTime dataInicio,
                               LocalDateTime dataTermino, Integer area) {

    public ListagemSafraDto(Safra safra){
        this(safra.getNome(),safra.getDataInicio(),safra.getDataTermino(),safra.getArea());
    }
}
