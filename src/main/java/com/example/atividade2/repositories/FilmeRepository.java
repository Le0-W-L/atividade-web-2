package com.example.atividade2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.atividade2.models.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
    public List<Filme> findByDuracaoGreaterThan(Integer duracao);

    public List<Filme> findByDuracaoLessThanEqual(Integer duracao);

    public List<Filme> findByTituloLike(String titulo);
}