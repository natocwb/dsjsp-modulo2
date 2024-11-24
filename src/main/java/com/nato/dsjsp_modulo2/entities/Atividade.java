package com.nato.dsjsp_modulo2.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "tb_atividade")
public class Atividade {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    private double preco;
    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;
    @OneToMany(mappedBy = "atividade")
    private List<Bloco> blocos = new ArrayList<>();


        @ManyToMany(mappedBy = "atividades")
        private Set<Participante> participantes = new HashSet<>();

    public Atividade() {}

    public Atividade(Long id, String nome, String descricao, double preco, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atividade atividade = (Atividade) o;
        return Objects.equals(getId(), atividade.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    public List<Bloco> getBlocos() {
        return blocos;
    }
}
