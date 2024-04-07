package br.com.fiap.cpjava.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor

@Entity
@Table(name="TB_COLHEITA")
public class Colheita {


    @Id
    @GeneratedValue
    @Column(name="cd_colheita", nullable = false)
    private String codigo;

    @Column(name="dt_colheita", nullable = false)
    private LocalDateTime dataColheita;

    @Column(name="dt_colheita", nullable = false)
    private Integer quantidade;

    @Column(name ="area_colheita")
    private String descricaoColheita;



    public Colheita(CadastroColheitaDto colheitaDto) {
        dataColheita = colheitaDto.dataColheita();
        quantidade = colheitaDto.quantidade();
        descricaoColheita = colheitaDto.descricaoColheita();
    }

}
