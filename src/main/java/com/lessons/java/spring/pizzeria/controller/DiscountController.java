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

import com.lessons.java.spring.pizzeria.model.Discount;
import com.lessons.java.spring.pizzeria.service.DiscountService;

import jakarta.validation.Valid;



@Controller
@RequestMapping("/discounts")
public class DiscountController {

	
	//SERVICE
	//REPOSITORY CAMPO CON AUTOWIRED CON D.I, DIRE ALL'APPLICATIVO DI INSTANZIARE IN AUTOMATICO IL SERVICE
	@Autowired
	private DiscountService service;
	
	
	/**
	 * 
	 * @return LA LISTA DI TUTTE LE OFFERTE;
	 */
	@GetMapping
	public String index(Model model) {
		
		//PRENDO I DATI DA MOSTRARE A "/discount/index":
		List<Discount> listDiscount;
		
		listDiscount = service.findAllDiscount();

		//INSERISCO I DATI DELLA LISTA NEL MODEL;
		model.addAttribute("discount", listDiscount);
		
		return "/discount/index";
		
	}
	
	
	/**
	 * MEMORIZZAZIONE DELL'OFFERTA CREATA NEL FORM;
	 * @return SE I DATI SONO SBAGLIATI, VIENE RIPROPOSTO IL FORM DA RICOMPILARE;
	 * @return UNA VOLTA SALVATI I DATI, VIENE RESTITUITA LA LISTA DELLE OFFERTE DELLA RELATIVA PIZZA SELEZIONATA;
	 */
	@PostMapping("/create")
	public String store(@Valid @ModelAttribute("discount") Discount formDiscount, BindingResult bindingResult, RedirectAttributes attributes, Model model) {
		
		//CONTROLLO SE I CAMPI COMPILATI SONO SBAGLIATI;
		//SE CI SONO ERRORI, VIENE RESTITUITA LA PAGINA DEL FORM DA RICOMPILARE;
		//IN CASO CONTRARIO, I DATI VENGONO SALVATI SUL DB;
		if(bindingResult.hasErrors())
			return "/discount/form-create-discount";
		
		service.create(formDiscount);
		
		attributes.addFlashAttribute("successMessageCreate", "Discount created...");
		
		return "redirect:/pizze/show/" + formDiscount.getPizza().getId();
		
	}
	
	
	/**
	 * VIENE MOSTRATO IL FORM CON I DATI DELL'OFFERTA CHE SI VUOLE MODIFICARE;
	 * @return I DATI DELL'OFFERTA RICHIESTA; 
	 * 
	 */
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id , Model model) {
		
		
		//INSERISCO I DATI DELL'OFFERTA NEL MODEL;
		model.addAttribute("discount", service.findById(id));
		
		return "/discount/form-edit-discount";
		
	}
	
	
	/**
	 * MODIFICA DELL'OFFERTA;
	 * @return SE I DATI SONO SBAGLIATI, VIENE RIPROPOSTO IL FORM DA RICOMPILARE;
	 * @return UNA VOLTA SALVATI I DATI, VIENE RESTITUITA LA LISTA DELLE OFFERTE DELLA RELATIVA PIZZA SELEZIONATA;
	 */
	@PostMapping("/edit/{id}")
	public String update(@Valid @ModelAttribute("discount") Discount formDiscount, BindingResult bindingResult, RedirectAttributes attributes, Model model) {
		
		//CONTROLLO SE I CAMPI COMPILATI SONO SBAGLIATI;
		//SE CI SONO ERRORI, VIENE RESTITUITA LA PAGINA DEL FORM DA RICOMPILARE;
		//IN CASO CONTRARIO, I DATI VENGONO SALVATI SUL DB;
		if(bindingResult.hasErrors())
			return "/discount/form-edit-discount";
		
		service.update(formDiscount);
		
		attributes.addFlashAttribute("successMessageUpdate", "Discount updated...");
		
		return "redirect:/pizze/show/" + formDiscount.getPizza().getId();
		
	}
	
	
}
