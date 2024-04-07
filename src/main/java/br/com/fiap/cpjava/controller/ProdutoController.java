package br.com.fiap.cpjava.controller;


import br.com.fiap.cpjava.dto.produtoDto.AtualizarProdutoDto;
import br.com.fiap.cpjava.dto.produtoDto.CadastrarProdutoDto;
import br.com.fiap.cpjava.dto.produtoDto.InformacaoProdutoDto;
import br.com.fiap.cpjava.dto.produtoDto.ListagemProdutoDto;
import br.com.fiap.cpjava.model.Produto;
import br.com.fiap.cpjava.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;


    //Fazendo a injeção dos dados no BD
    @PostMapping
    @Transactional
    public ResponseEntity<InformacaoProdutoDto> post(@RequestBody CadastrarProdutoDto produtoDto, UriComponentsBuilder uriBuilder) {
        var produto = new Produto(produtoDto);
        produtoRepository.save(produto);
        var uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new InformacaoProdutoDto(produto));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<InformacaoProdutoDto> put(@PathVariable("id") Long id,
                                                       @RequestBody AtualizarProdutoDto dto) {
        var produto = produtoRepository.getReferenceById(id);
        produto.atualizarProduto(dto);
        return ResponseEntity.ok(new InformacaoProdutoDto(produto));
    }

    @GetMapping("{id}")
    public ResponseEntity<InformacaoProdutoDto> get(@PathVariable("id") Long id) {
        var produto = produtoRepository.getReferenceById(id);
        return ResponseEntity.ok(new InformacaoProdutoDto(produto));
    }

    @GetMapping
    public ResponseEntity<List<ListagemProdutoDto>> get(Pageable pageable) {
        var listaDto = produtoRepository.findAll(pageable)
                .stream().map(ListagemProdutoDto::new).toList();
        return ResponseEntity.ok(listaDto);

    }
}
