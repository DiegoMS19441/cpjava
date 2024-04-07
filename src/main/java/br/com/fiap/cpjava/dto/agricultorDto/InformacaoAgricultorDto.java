package br.com.fiap.cpjava.dto.agricultorDto;

import br.com.fiap.cpjava.model.Agricultor;

public record InformacaoAgricultorDto(Long id, String nome, String email, String endereco, String telefone) {

    public InformacaoAgricultorDto(Agricultor agricultor){
        this(agricultor.getId(),agricultor.getNome(),agricultor.getEmail(),agricultor.getEndereco(),
                agricultor.getTelefone());
    }
}
