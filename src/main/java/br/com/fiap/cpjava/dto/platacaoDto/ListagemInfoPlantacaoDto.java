package br.com.fiap.cpjava.dto.platacaoDto;

import br.com.fiap.cpjava.model.InfoPlantacao;

public record ListagemInfoPlantacaoDto(String clima, String solo, Integer areaPlantada) {

    public ListagemInfoPlantacaoDto(InfoPlantacao infoPlantacao){
        this(infoPlantacao.getClima(), infoPlantacao.getSolo(), infoPlantacao.getAreaPlantada());
    }
}
