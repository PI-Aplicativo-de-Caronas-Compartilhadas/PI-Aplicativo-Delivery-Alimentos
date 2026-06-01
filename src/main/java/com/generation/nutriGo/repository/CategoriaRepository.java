package com.generation.nutriGo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.nutriGo.model.Categoria;
import com.generation.nutriGo.model.Usuario;

public interface CategoriaRepository extends JpaRepository <Categoria, Long> {
	public List<Categoria> findAllByNomeContainingIgnoreCase(String nome);
	
}
