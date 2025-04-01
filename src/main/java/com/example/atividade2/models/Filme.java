package com.example.atividade2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "filmes")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Integer duracao;

    @ManyToOne
    @JoinColumn(name = "diretor_id", nullable = false)
    private Diretor diretor;

    public Filme() {
    }

    public Filme(Long id, String titulo, Integer duracao, Diretor diretor) {
        this.id = id;
        this.titulo = titulo;
        this.duracao = duracao;
        this.diretor = diretor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }

    @Override
    public String toString() {
        return "Filme [id=" + id + ", titulo=" + titulo + ", duracao=" + duracao + ", diretor=" + diretor.getNome() + "]";
    }
}
