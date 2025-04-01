package com.example.atividade2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.atividade2.models.Diretor;

public interface DiretorRepository extends JpaRepository<Diretor, Long>{
    public List<Diretor> findByNomeLike(String nome);

    @Query("SELECT d FROM Diretor d LEFT JOIN FETCH d.filmes WHERE d.id = :id")
    Diretor findByIdWithMovies(@Param("id") Long id);
}