package br.com.fiap.cpjava.model;

import br.com.fiap.cpjava.dto.agricultorDto.AtualizarAgricultorDto;
import br.com.fiap.cpjava.dto.agricultorDto.CadastrarAgricultorDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
@Entity
@Table(name="TB_AGRICULTOR")
public class Agricultor {

    @Id
    @GeneratedValue
    @Column(name="id_agricultor")
    private Long id;

    @Column(name="nm_agricultor", nullable = false)
    private String nome;

    @Column(name="cpf_agricultor")
    private String cpf;

    @Column(name="email_agricultor")
    private String email;

    @Column(name="des_endereco",nullable = false)
    private String endereco;

    @Column(name="tel_agricultor",nullable = false)
    private String telefone;

    public Agricultor(CadastrarAgricultorDto agricultorDto) {
        nome = agricultorDto.nome();
        cpf = agricultorDto.cpf();
        email = agricultorDto.email();
        endereco = agricultorDto.endereco();
        telefone = agricultorDto.telefone();
    }



    public void atualizarAgricultor(AtualizarAgricultorDto dto) {
        if (dto.nome() != null)
            nome = dto.nome();
        if (dto.cpf() != null)
            cpf = dto.cpf();
        if (dto.email() != null)
            email = dto.email();
        if (dto.endereco() != null)
            endereco = dto.endereco();
        if (dto.telefone() != null)
            telefone = dto.telefone();
    }

}
