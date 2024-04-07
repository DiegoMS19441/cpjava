package br.com.fiap.cpjava.dto.platacaoDto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CadastrarInfoPlatacaoDto(

        @NotNull
        String clima,

        @NotNull
        @NotBlank
        String Solo,

        @NotNull
        @Size(min=1)
        Integer areaPlantada
) {
}
