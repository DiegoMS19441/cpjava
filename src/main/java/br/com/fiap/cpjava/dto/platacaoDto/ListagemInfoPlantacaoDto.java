package br.com.fiap.cpjava.dto.platacaoDto;

import br.com.fiap.cpjava.model.InfoPlantacao;

public record ListagemInfoPlantacaoDto(Long id, String clima, String solo, Integer areaPlantada) {

    public ListagemInfoPlantacaoDto(InfoPlantacao infoPlantacao){
        this(infoPlantacao.getId(), infoPlantacao.getClima(), infoPlantacao.getSolo()
                , infoPlantacao.getAreaPlantada());
    }
}
