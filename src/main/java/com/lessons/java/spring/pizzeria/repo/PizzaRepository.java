package com.lessons.java.spring.pizzeria.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lessons.java.spring.pizzeria.model.Pizza;


public interface PizzaRepository extends JpaRepository<Pizza, Integer>{

	/*
	 * QUERY CUSTOM PER CERCARE LA PIZZA TRAMITE NOME;
	 */
	public List<Pizza> findByName(String name);
	
}
