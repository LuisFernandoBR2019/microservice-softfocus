package com.luisfernando.produtos.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luisfernando.produtos.model.Produto;
import com.luisfernando.produtos.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class ProdutoApi {

    @Autowired
    private ProdutosRepository repository;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping
    public List<Produto> all() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Produto> one(@PathVariable("id") Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Produto insert(@RequestBody Produto produto) throws JsonProcessingException {
        repository.save(produto);
        var produtoJson = objectMapper.writeValueAsString(produto);
        jmsTemplate.convertAndSend("queue.produto.insert", produtoJson);
        return produto;
    }

    @DeleteMapping
    public void delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
    }

}
