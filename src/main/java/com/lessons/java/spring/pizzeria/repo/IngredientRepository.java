package com.lessons.java.spring.pizzeria.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lessons.java.spring.pizzeria.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer>{

	/*
	 * QUERY CUSTOM PER CERCARE L'INGREDIENTE TRAMITE NOME;
	 */
	public List<Ingredient> findByName(String name);
}

