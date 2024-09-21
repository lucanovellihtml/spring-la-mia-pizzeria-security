package com.lessons.java.spring.pizzeria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lessons.java.spring.pizzeria.model.Ingredient;
import com.lessons.java.spring.pizzeria.repo.IngredientRepository;

@Service
public class IngredientService {

			//REPOSITORY
			//REPOSITORY CAMPO CON AUTOWIRED CON D.I
			@Autowired
			private IngredientRepository repository;
			
			
			/**
			 * 
			 * @param name, NOME DELL'INGREDIENTE;
			 * @return TUTTE LE INFORMAZIONI DELL'INGREDIENTE SPECIFICO RICERCATO;
			 */
			public List<Ingredient> findAllByTitle(String name){
				
				return repository.findByName(name);
				
			}
			
			
			/**
			 * 
			 * @return LA LISTA DEGLI INGREDIENTI PRESENTI NEL REPOSITORY;
			 */
			public List<Ingredient> findAllIngredients(){
				
				return repository.findAll();
				
			}


			/**
			 * 
			 * @param id, ID DELL'INGREDIENTE;
			 * @return TUTTE LE INFORMAZIONI DELL'INGREDIENTE SPECIFICO RICERCATO;
			 */
			public Ingredient findById(int id){
				
				return repository.findById(id).get();
				
			}


			/**
			 * @param Ingredient, OGGETTO INGREDIENTE DA CREARE NELLA REPOSITORY;
			 * @return INGREDIENTE DA CREARE;
			 */
			public Ingredient create(Ingredient ingredient){
			
				return repository.save(ingredient);
				
			}


			/**
			 * @param Ingredient, OGGETTO INGREDIENTE DA AGGIORNARE NELLA REPOSITORY;
			 * @return INGREDIENTE DA AGGIORNARE;
			 */
			public Ingredient update(Ingredient ingredient){
			
				return repository.save(ingredient);
				
			}
			
			
			/**
			 * @param id, ID DELL'INGRDIENTE DA ELIMINARE;
			 */
			public void delete(int id){
			
				repository.deleteById(id);
				
			}
	
	
}
