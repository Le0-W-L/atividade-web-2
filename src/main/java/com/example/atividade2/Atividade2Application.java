package com.example.atividade2;

import com.example.atividade2.repositories.DiretorRepository;
import com.example.atividade2.repositories.FilmeRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.atividade2.models.Diretor;
import com.example.atividade2.models.Filme;

@SpringBootApplication
public class Atividade2Application {

	@Bean
	public CommandLineRunner init(
			@Autowired FilmeRepository filmeRepository,
			@Autowired DiretorRepository diretorRepository) {
		return args -> {
			System.out.println("---- Adicionando Diretores ----");
			Diretor diretor = diretorRepository.save(new Diretor(null, "Nolan"));
			Diretor diretor2 = diretorRepository.save(new Diretor(null, "Jon Watts"));

			System.out.println("---- Listando Diretores pelo começo do Nome ----");
			List<Diretor> diretores = diretorRepository.findByNomeLike("N%");
			diretores.forEach(System.out::println);

			System.out.println("---- Adicionando os Filmes ----");
			filmeRepository.save(new Filme(null, "Interstellar", 180, diretor));
			filmeRepository.save(new Filme(null, "Oppenheimer", 190, diretor));
			filmeRepository.save(new Filme(null, "Spier-Man", 120, diretor2));

			System.out.println("---- Duração Maior que X ----");
			List<Filme> filmes = filmeRepository.findByDuracaoGreaterThan(120);
			filmes.forEach(System.out::println);

			System.out.println("---- Duração Menor ou Igual a X ----");
			filmes = filmeRepository.findByDuracaoLessThanEqual(180);
			filmes.forEach(System.out::println);

			System.out.println("---- Nome do Filme ----");
			filmes = filmeRepository.findByTituloLike("S%");
			filmes.forEach(System.out::println);

			System.out.println("---- Buscando Diretor pelo ID e seus Filmes ----");
			Diretor diretorComFilmes = diretorRepository.findByIdWithMovies(diretor.getId());

			System.out.println("Diretor: " + diretorComFilmes.getNome());
			System.out.println("Filmes do Diretor:");
			diretorComFilmes.getFilmes()
					.forEach(filme -> System.out.println(filme.getTitulo() + " - " + filme.getDuracao() + " min"));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Atividade2Application.class, args);
	}
}