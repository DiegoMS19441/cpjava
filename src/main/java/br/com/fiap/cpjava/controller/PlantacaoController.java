package br.com.fiap.cpjava.controller;


import br.com.fiap.cpjava.dto.platacaoDto.AtualizarInfoPlatacaoDto;
import br.com.fiap.cpjava.dto.platacaoDto.CadastrarInfoPlatacaoDto;
import br.com.fiap.cpjava.dto.platacaoDto.DetalhePlatacaoDto;
import br.com.fiap.cpjava.model.InfoPlantacao;
import br.com.fiap.cpjava.repository.InfoPlantacaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("infoplantacoes")
public class PlantacaoController {

    @Autowired
    private InfoPlantacaoRepository InfoPlantacaoRepository;


    //Fazendo a injeção dos dados no BD
    @PostMapping
    @Transactional
    public ResponseEntity<DetalhePlatacaoDto> post(@RequestBody CadastrarInfoPlatacaoDto PlantacaoDto, UriComponentsBuilder uriBuilder) {
        var InfoPlantacao = new InfoPlantacao(PlantacaoDto);
        InfoPlantacaoRepository.save(InfoPlantacao);
        var uri = uriBuilder.path("/infoplantacaoes/{id}").buildAndExpand(InfoPlantacao.getId()).toUri();
        return ResponseEntity.created(uri).body(new DetalhePlatacaoDto(InfoPlantacao));
    }
    @DeleteMapping("{id}")
    @org.springframework.transaction.annotation.Transactional
    public ResponseEntity<Void> delete(@PathVariable("id")Long id){
        InfoPlantacaoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<DetalhePlatacaoDto> put(@PathVariable("id")Long id,
                                                       @RequestBody AtualizarInfoPlatacaoDto dto){
        var InfoPlantacao = InfoPlantacaoRepository.getReferenceById(id);
        InfoPlantacao.atualizarInfoPlantacao(dto);
        return ResponseEntity.ok(new DetalhePlatacaoDto(InfoPlantacao));
    }
    @GetMapping("{id}")
    public ResponseEntity<DetalhePlatacaoDto> get(@PathVariable("id")Long id){
        var InfoPlantacao = InfoPlantacaoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DetalhePlatacaoDto(InfoPlantacao));
    }
}
