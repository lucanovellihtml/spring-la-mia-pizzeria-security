package com.lessons.java.spring.pizzeria.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lessons.java.spring.pizzeria.model.Discount;


public interface DiscountRepository extends JpaRepository<Discount, Integer>{

	/*
	 * QUERY CUSTOM PER CERCARE L'OFFERTA TRAMITE TITLE;
	 */
	public List<Discount> findByTitle(String title);
	
}
