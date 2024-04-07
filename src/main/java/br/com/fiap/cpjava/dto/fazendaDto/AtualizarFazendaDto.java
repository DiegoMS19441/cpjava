package br.com.fiap.cpjava.dto.fazendaDto;

public record AtualizarFazendaDto(Long id, String cnpj, String nome, String endereco,
                                  String cep, String email, String telefone, Integer hectares) {
}
