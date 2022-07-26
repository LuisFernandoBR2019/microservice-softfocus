package com.luisfernando.produtos.model;

import reactor.util.annotation.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name= "DESCRICAO", nullable = false, length = 100)
    private String descricao;

    @Column(name= "VALOR", nullable = false, scale = 10, precision = 2)
    private BigDecimal valor;

    @Deprecated
    public Produto(){

    }

    private Produto (@NonNull String descricao, @NonNull BigDecimal valor){
        setDescricao(descricao);
        setValor(valor);
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(@NonNull String descricao) {
        this.descricao = Objects.requireNonNull(descricao, "descrição não pode ser nula");
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(@NonNull BigDecimal valor) {
        this.valor = Objects.requireNonNull(valor, "Valor não pode ser nulo");;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
