package com.luisfernando.produtos.repository;

import com.luisfernando.produtos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produto, Long> {
}
