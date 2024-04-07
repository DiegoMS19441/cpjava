package br.com.fiap.cpjava.controller;

import br.com.fiap.cpjava.dto.safraDto.AtualizarSafraDto;
import br.com.fiap.cpjava.dto.safraDto.CadastrarSafraDto;
import br.com.fiap.cpjava.dto.safraDto.InformacaoSafraDto;
import br.com.fiap.cpjava.model.Safra;
import br.com.fiap.cpjava.repository.SafraRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("safras")
public class SafraController {

    @Autowired
    private SafraRepository safraRepository;


    //Fazendo a injeção dos dados no BD
    @PostMapping
    @Transactional
    public ResponseEntity<InformacaoSafraDto> post(@RequestBody CadastrarSafraDto safraDto, UriComponentsBuilder uriBuilder) {
        var safra = new Safra(safraDto);
        safraRepository.save(safra);
        var uri = uriBuilder.path("/safraes/{id}").buildAndExpand(safra.getId()).toUri();
        return ResponseEntity.created(uri).body(new InformacaoSafraDto(safra));
    }
    @DeleteMapping("{id}")
    @org.springframework.transaction.annotation.Transactional
    public ResponseEntity<Void> delete(@PathVariable("id")Long id){
        safraRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<InformacaoSafraDto> put(@PathVariable("id")Long id,
                                                       @RequestBody AtualizarSafraDto dto){
        var safra = safraRepository.getReferenceById(id);
        safra.atualizarSafra(dto);
        return ResponseEntity.ok(new InformacaoSafraDto(safra));
    }
    @GetMapping("{id}")
    public ResponseEntity<InformacaoSafraDto> get(@PathVariable("id")Long id){
        var safra = safraRepository.getReferenceById(id);
        return ResponseEntity.ok(new InformacaoSafraDto(safra));
    }
}
