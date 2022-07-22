package com.luisfernando.produtos.api;

import com.luisfernando.produtos.model.Produto;
import com.luisfernando.produtos.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class ProdutoApi {

    @Autowired
    private ProdutosRepository repository;

    @GetMapping
    public List<Produto> all() {
        return repository.findAll();
    }

    @GetMapping("{id}")
    public Optional<Produto> one(@PathVariable("id") Long id) {
        return repository.findById(id);
    }

    @PostMapping
    public Produto insert(@RequestBody Produto produto){
        return repository.save(produto);
    }

    @DeleteMapping
    public void delete (@PathVariable("id") Long id){
        repository.deleteById(id);
    }

}