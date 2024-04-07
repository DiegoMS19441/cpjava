package br.com.fiap.cpjava.controller;

import br.com.fiap.cpjava.dto.fazendaDto.AtualizarFazendaDto;
import br.com.fiap.cpjava.dto.fazendaDto.CadastrarFazendaDto;
import br.com.fiap.cpjava.dto.fazendaDto.InformacaoFazendaDto;
import br.com.fiap.cpjava.dto.fazendaDto.ListagemFazendaDto;
import br.com.fiap.cpjava.model.Fazenda;
import br.com.fiap.cpjava.repository.FazendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
    @RequestMapping("fazendas")
    public class FazendaController {

        @Autowired
        private FazendaRepository fazendaRepository;


        //Fazendo a injeção dos dados no BD
        @PostMapping
        @Transactional
        public ResponseEntity<InformacaoFazendaDto> post(@RequestBody CadastrarFazendaDto fazendaDto, UriComponentsBuilder uriBuilder) {
            var fazenda = new Fazenda(fazendaDto);
            fazendaRepository.save(fazenda);
            var uri = uriBuilder.path("/fazendas/{id}").buildAndExpand(fazenda.getId()).toUri();
            return ResponseEntity.created(uri).body(new InformacaoFazendaDto(fazenda));
        }
        @DeleteMapping("{id}")
        @org.springframework.transaction.annotation.Transactional
        public ResponseEntity<Void> delete(@PathVariable("id")Long id){
            fazendaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        @PutMapping("{id}")
        @Transactional
        public ResponseEntity<InformacaoFazendaDto> put(@PathVariable("id")Long id,
                                                           @RequestBody AtualizarFazendaDto dto){
            var fazenda = fazendaRepository.getReferenceById(id);
            fazenda.atualizarFazenda(dto);
            return ResponseEntity.ok(new InformacaoFazendaDto(fazenda));
        }
        @GetMapping("{id}")
        public ResponseEntity<InformacaoFazendaDto> get(@PathVariable("id")Long id){
            var fazenda = fazendaRepository.getReferenceById(id);
            return ResponseEntity.ok(new InformacaoFazendaDto(fazenda));
        }
    @GetMapping
    public ResponseEntity<List<ListagemFazendaDto>> get(Pageable pageable) {
        var listaDto = fazendaRepository.findAll(pageable)
                .stream().map(ListagemFazendaDto::new).toList();
        return ResponseEntity.ok(listaDto);

    }
}

