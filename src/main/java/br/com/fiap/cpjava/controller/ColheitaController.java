package br.com.fiap.cpjava.controller;

import br.com.fiap.cpjava.dto.agricultorDto.AtualizarAgricultorDto;
import br.com.fiap.cpjava.dto.agricultorDto.CadastrarAgricultorDto;
import br.com.fiap.cpjava.dto.agricultorDto.InformacaoAgricultorDto;
import br.com.fiap.cpjava.dto.agricultorDto.ListagemAgricultorDto;
import br.com.fiap.cpjava.dto.colheitaDto.AtualizarColheitaDto;
import br.com.fiap.cpjava.dto.colheitaDto.CadastrarColheitaDto;
import br.com.fiap.cpjava.dto.colheitaDto.InformacaoColheitaDto;
import br.com.fiap.cpjava.dto.colheitaDto.ListagemColheitaDto;
import br.com.fiap.cpjava.model.Agricultor;
import br.com.fiap.cpjava.model.Colheita;
import br.com.fiap.cpjava.repository.AgricultorRepository;
import br.com.fiap.cpjava.repository.ColheitaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("colheitas")
public class ColheitaController {

    @Autowired
    private ColheitaRepository colheitaRepository;


    //Fazendo a injeção dos dados no BD
    @PostMapping
    @Transactional
    public ResponseEntity<InformacaoColheitaDto> post(@RequestBody CadastrarColheitaDto colheitaDto, UriComponentsBuilder uriBuilder) {
        var colheita = new Colheita(colheitaDto);
        colheitaRepository.save(colheita);
        var uri = uriBuilder.path("/colheitas/{id}").buildAndExpand(colheita.getId()).toUri();
        return ResponseEntity.created(uri).body(new InformacaoColheitaDto(colheita));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        colheitaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<InformacaoColheitaDto> put(@PathVariable("id") Long id,
                                                       @RequestBody AtualizarColheitaDto dto) {
        var colheita = colheitaRepository.getReferenceById(id);
        colheita.atualizarColheita(dto);
        return ResponseEntity.ok(new InformacaoColheitaDto(colheita));
    }

    @GetMapping("{id}")
    public ResponseEntity<InformacaoColheitaDto> get(@PathVariable("id") Long id) {
        var colheita = colheitaRepository.getReferenceById(id);
        return ResponseEntity.ok(new InformacaoColheitaDto(colheita));
    }

    @GetMapping
    public ResponseEntity<List<ListagemColheitaDto>> get(Pageable pageable) {
        var listaDto = colheitaRepository.findAll(pageable)
                .stream().map(ListagemColheitaDto::new).toList();
        return ResponseEntity.ok(listaDto);

    }
}

