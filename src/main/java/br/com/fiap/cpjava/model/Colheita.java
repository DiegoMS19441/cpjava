package br.com.fiap.cpjava.model;

import br.com.fiap.cpjava.dto.colheitaDto.AtualizarColheitaDto;
import br.com.fiap.cpjava.dto.colheitaDto.CadastrarColheitaDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor

@Entity
@Table(name="TB_COLHEITA")
public class Colheita {


    @Id
    @GeneratedValue

    @Column(name="id_colheita", nullable = false)
    private Long id;

    @Column(name="dt_colheita", nullable = false)
    private LocalDateTime dataColheita;

    @Column(name="qnt_colheita", nullable = false)
    private Integer quantidade;

    @Column(name ="area_colheita")
    private String descricaoColheita;



    public Colheita(CadastrarColheitaDto colheitaDto) {
        dataColheita = colheitaDto.dataColheita();
        quantidade = colheitaDto.quantidade();
        descricaoColheita = colheitaDto.descricaoColheita();
    }
    public void atualizarColheita(AtualizarColheitaDto dto) {
        if (dto.dataColheita() != null)
            dataColheita = dto.dataColheita();
        if (dto.quantidade() != null)
            quantidade = dto.quantidade();

    }

}
