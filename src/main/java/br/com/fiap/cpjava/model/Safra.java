package br.com.fiap.cpjava.model;

import br.com.fiap.cpjava.dto.safraDto.AtualizarSafraDto;
import br.com.fiap.cpjava.dto.safraDto.CadastrarSafraDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "TB_SAFRA")
public class Safra {

    @Id
    @GeneratedValue
    @Column(name = "id_safra")
    private Long id;

    @Column(name = "nome_safra", nullable = false, length = 100)
    private String nome;

    @Column(name = "dt_inicio", nullable = false)
    private LocalDateTime dataInicio;

    @Column(name = "dt_safra", nullable = false)
    private LocalDateTime dataTermino;

    @Column(name = "area_safra")
    private Integer area;

    public Safra(CadastrarSafraDto safraDto) {
        nome = safraDto.nome();
        dataInicio = safraDto.dataInicio();
        dataTermino = safraDto.dataTermino();
        area = safraDto.area();
    }

    public void atualizarSafra(AtualizarSafraDto dto) {
        if (dto.nome() != null)
            nome = dto.nome();
        if (dto.dataInicio() != null)
            dataInicio = dto.dataInicio();
        if (dto.dataTermino() != null)
            dataTermino = dto.dataTermino();
        if (dto.area() != null)
            area = dto.area();
    }

}
