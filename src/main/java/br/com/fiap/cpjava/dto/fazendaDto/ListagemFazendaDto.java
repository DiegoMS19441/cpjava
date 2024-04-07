package br.com.fiap.cpjava.dto.fazendaDto;

import br.com.fiap.cpjava.model.Fazenda;

public record ListagemFazendaDto(Long id, String cnpj, String nome, String endereco, String cep, String email,
                                 String telefone, Integer hectares) {

    public ListagemFazendaDto(Fazenda fazenda){
        this(fazenda.getId(),fazenda.getCnpj(),fazenda.getNome(),fazenda.getEndereco(),
                fazenda.getCep(),fazenda.getEmail(), fazenda.getTelefone(),fazenda.getHectares());
    }
}
