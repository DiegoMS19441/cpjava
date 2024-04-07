package br.com.fiap.cpjava.model;

import br.com.fiap.cpjava.dto.platacaoDto.AtualizarInfoPlatacaoDto;
import br.com.fiap.cpjava.dto.platacaoDto.CadastrarInfoPlatacaoDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor

@Entity
@Table(name="TB_INFO_PLANTACAO")
public class InfoPlantacao {

    @Id
    @GeneratedValue

    @Column(name="id_plantacao")
    private Long id;

    @Column(name="des_clima")
    private String clima;

    @Column(name="des_solo", length = 30, nullable = false)
    private String solo;

    @Column(name="tm_area_platada")
    private Integer areaPlantada;
    public InfoPlantacao(CadastrarInfoPlatacaoDto PlantacaoDto) {
        clima = PlantacaoDto.clima();
        solo = PlantacaoDto.Solo();
        areaPlantada = PlantacaoDto.areaPlantada();
    }

    public void atualizarInfoPlantacao(AtualizarInfoPlatacaoDto dto) {
        if (dto.clima() != null)
            clima = dto.clima();
        if (dto.solo() != null)
            solo = dto.solo();
        if (dto.areaPlantada() != null)
            areaPlantada = dto.areaPlantada();
    }

}
