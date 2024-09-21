package com.lessons.java.spring.pizzeria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lessons.java.spring.pizzeria.model.Discount;
import com.lessons.java.spring.pizzeria.repo.DiscountRepository;

@Service
public class DiscountService {

		//REPOSITORY
		//REPOSITORY CAMPO CON AUTOWIRED CON D.I
		@Autowired
		private DiscountRepository repository;
		
		
		/**
		 * 
		 * @param title, NOME DELL'OFFERTA;
		 * @return TUTTE LE INFORMAZIONI DELLA SPECIFICA OFFERTA RICERCATA;
		 */
		public List<Discount> findAllByTitle(String title){
			
			return repository.findByTitle(title);
			
		}
		
		
		/**
		 * 
		 * @return LA LISTA DELLE OFFERTE PRESENTI NEL REPOSITORY;
		 */
		public List<Discount> findAllDiscount(){
			
			return repository.findAll();
			
		}


		/**
		 * 
		 * @param searchId, ID DELL'OFFERTA;
		 * @return TUTTE LE INFORMAZIONI DELLA SPECIFICA DELL'OFFERTA RICERCATA;
		 */
		public Discount findById(int id){
			
			return repository.findById(id).get();
			
		}


		/**
		 * @param Discount, OGGETTO OFFERTA DA CREARE NELLA REPOSITORY;
		 * @return L'OFFERTA DA CREARE;
		 */
		public Discount create(Discount discount){
		
			return repository.save(discount);
			
		}


		/**
		 * @param Discount, OGGETTO OFFERTA DA AGGIORNARE NELLA REPOSITORY;
		 * @return L'OFFERTA DA AGGIORNARE;
		 */
		public Discount update(Discount discount){
		
			return repository.save(discount);
			
		}
		
		
		/**
		 * @param searchId, ID DELL'OFFERTA DA ELIMINARE;
		 */
		public void delete(int id){
		
			repository.deleteById(id);
			
		}
	
	
	
}
