package com.lessons.java.spring.pizzeria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lessons.java.spring.pizzeria.model.Pizza;
import com.lessons.java.spring.pizzeria.repo.PizzaRepository;

@Service
public class PizzaService {

	//REPOSITORY
	//REPOSITORY CAMPO CON AUTOWIRED CON D.I
	@Autowired
	private PizzaRepository repository;
	
	
	/**
	 * 
	 * @param searchText, NOME DELLA PIZZA;
	 * @return TUTTE LE INFORMAZIONI DELLA SPECIFICA PIZZA RICERCATA;
	 */
	public List<Pizza> findAllByName(String name){
		
		return repository.findByName(name);
		
	}
	
	
	/**
	 * 
	 * @return LA LISTA DELLE PIZZE PRESENTI NEL REPOSITORY;
	 */
	public List<Pizza> findAllPizza(){
		
		return repository.findAll();
		
	}


	/**
	 * 
	 * @param searchId, ID DELLA PIZZA;
	 * @return TUTTE LE INFORMAZIONI DELLA SPECIFICA PIZZA RICERCATA;
	 */
	public Pizza findById(int id){
		
		return repository.findById(id).get();
		
	}


	/**
	 * @param pizza, OGGETTO PIZZA DA CREARE NELLA REPOSITORY;
	 * @return LA PIZZA DA CREARE;
	 */
	public Pizza create(Pizza pizza){
	
		return repository.save(pizza);
		
	}


	/**
	 * @param pizza, OGGETTO PIZZA DA AGGIORNARE NELLA REPOSITORY;
	 * @return LA PIZZA DA AGGIORNARE;
	 */
	public Pizza update(Pizza pizza){
	
		return repository.save(pizza);
		
	}
	
	
	/**
	 * @param searchId, ID DELLA PIZZA DA ELIMINARE;
	 */
	public void delete(int id){
	
		repository.deleteById(id);
		
	}
	
	

}
