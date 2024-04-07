package br.com.fiap.cpjava.model;

import br.com.fiap.cpjava.dto.fazendaDto.AtualizarFazendaDto;
import br.com.fiap.cpjava.dto.fazendaDto.CadastrarFazendaDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter @Setter
@NoArgsConstructor

@Entity
@Table(name="TB_FAZENDA")
@EntityListeners(AuditingEntityListener.class)
public class Fazenda {

    @Id
    @GeneratedValue
    @Column(name="id_fazenda")
    private Long id;

    @Column(name="cnpj_fazenda", length = 14, nullable = false)
    private String cnpj;

    @Column(name="nm_fazenda", nullable = false, length = 11, unique = true)
    private String nome;

    @Column(name="des_endereco", nullable = false)
    private String endereco;

    @CreatedDate
    @Column(name="cep_fazenda", nullable = false)
    private String cep;

    @Column(name="email_fazenda", nullable = false, length = 30)
    private String email;

    @Column(name="tel_fazenda", precision = 7)
    private String telefone;

    @Column(name="hectares_fazenda", precision = 7)
    private Integer hectares;

    public Fazenda(CadastrarFazendaDto fazendaDto) {
        cnpj = fazendaDto.cnpj();
        nome = fazendaDto.nome();
        endereco = fazendaDto.endereco();
        cep = fazendaDto.cep();
        email = fazendaDto.email();
        telefone = fazendaDto.telefone();
        hectares = fazendaDto.hectares();
    }

    public void atualizarFazenda(AtualizarFazendaDto dto) {
        if (dto.cnpj() != null)
            cnpj = dto.cnpj();
        if (dto.nome() != null)
            nome = dto.nome();
        if (dto.endereco() != null)
            endereco = dto.endereco();
        if (dto.cep() != null)
            cep = dto.cep();
        if (dto.email() != null)
            email = dto.email();
        if (dto.telefone() != null)
            telefone = dto.telefone();
        if (dto.hectares() != null)
            hectares = dto.hectares();
    }
}
