package br.com.fiap.cpjava.dto.agricultorDto;

import br.com.fiap.cpjava.model.Agricultor;

public record ListagemAgricultorDto(Long id, String nome, String cpf, String email,
                                    String endereco, String telefone) {

    public ListagemAgricultorDto(Agricultor agricultor){
        this(agricultor.getId(), agricultor.getNome(), agricultor.getCpf(), agricultor.getEmail(),
                agricultor.getEndereco(),agricultor.getTelefone());
    }
}
