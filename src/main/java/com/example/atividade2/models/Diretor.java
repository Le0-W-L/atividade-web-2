package com.example.atividade2.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "diretores")
public class Diretor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "diretor")
    private List<Filme> filmes = new ArrayList<>();


    public Diretor(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Diretor() {
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
    
    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public void addFilme(Filme filme) {
        filmes.add(filme);
        filme.setDiretor(this);
    }

    public void removeFilme(Filme filme) {
        filmes.remove(filme);
        filme.setDiretor(null);
    }

    @Override
    public String toString() {
        return "Diretor [id=" + id + ", nome=" + nome + "]";
    }
}