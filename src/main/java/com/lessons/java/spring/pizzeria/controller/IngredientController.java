package com.lessons.java.spring.pizzeria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lessons.java.spring.pizzeria.model.Ingredient;
import com.lessons.java.spring.pizzeria.service.IngredientService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ingredients")
public class IngredientController {
	
	//SERVICE
	//REPOSITORY CAMPO CON AUTOWIRED CON D.I, DIRE ALL'APPLICATIVO DI INSTANZIARE IN AUTOMATICO IL SERVICE
	@Autowired
	private IngredientService service;
	
	
	/**
	 * @return LA LISTA DI TUTTI GLI INGREDIENTI;
	 */
	@GetMapping
	public String index(Model model) {
		
		//PRENDO I DATI DA MOSTRARE A "/ingredient/index":
		List<Ingredient> listIngredients;
		
		listIngredients = service.findAllIngredients();

		//INSERISCO I DATI DELLA LISTA NEL MODEL;
		model.addAttribute("ingredients", listIngredients);
		
		return "/ingredient/index";
		
	}
	
	
	/**
	 * CREAZIONE DEL SINGOLO INGREDIENTE;
	 * @return FORM PER LA CREAZIONE DEL SINGOLO INGREDIENTE;
	 */
	@GetMapping("/create")
	public String create(Model model) {
		
		//INSERISCO L'OGGETTO INGREDIENTE VUOTO;
		//QUESTO PER PERMETTERE DI RICHIMARE SEMPRE LA PAGINA ANCHE SENZA DATI;
		model.addAttribute("ingredient", new Ingredient());
		
		return "/ingredient/form-create-ingredient";
		
	}
	
	
	/**
	 * MEMORIZZAZIONE DELLA SINGOLO INGREDIENTE CREATO NEL FORM;
	 * @return SE I DATI SONO SBAGLIATI, VIENE RIPROPOSTO IL FORM DA RICOMPILARE;
	 * @return UNA VOLTA SALVATI I DATI, VIENE RESTITUITA LA LISTA DEGLI INGREDIENTI;
	 */
	@PostMapping("/create")
	public String store(@Valid @ModelAttribute("ingredient") Ingredient formIngredient, BindingResult bindingResult, RedirectAttributes attributes, Model model) {
		
		//CONTROLLO SE I CAMPI COMPILATI SONO SBAGLIATI;
		//SE CI SONO ERRORI, VIENE RESTITUITA LA PAGINA DEL FORM DA RICOMPILARE;
		//IN CASO CONTRARIO, I DATI VENGONO SALVATI SUL DB;
		if(bindingResult.hasErrors())
			return "/ingredient/form-create-ingredient";
		
		service.create(formIngredient);
		
		attributes.addFlashAttribute("successMessageCreate", "Ingredient created...");
		
		return "redirect:/ingredients";
		
	}
	
	
	/**
	 * ELIMINATO IL RECORD DAL REPOSITORY;
	 * @return LA LISTA AGGIORNATA; 
	 * 
	 */
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id, RedirectAttributes attributes) {
		
		//ELIMINO I DATI DELL'INGREDIENTE DAL REPOSITORY;
		service.delete(id);
		
		attributes.addFlashAttribute("successMessageDelete", "Ingredient deleted...");
		
		return "redirect:/ingredients";
		
	}

}
