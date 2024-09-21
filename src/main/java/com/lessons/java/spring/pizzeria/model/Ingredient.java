package com.lessons.java.spring.pizzeria.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;



//ENTITA' INGREDIENTE;
@Entity
@Table(name = "ingredients")
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(min=2, max=255)
	private String name;
	
	// 1 - OGGETTO PER STABILIRE LA RELAZIONE CON L'ALTRA ENTITA';
	// 2 - DENTRO AL "mappedBy" FACCIO RIFERIMENTO ALLA VARIABILE D'ISTANZA CHE E' PRESENTE NELL'ENTITA'(PIZZA) A CUI E' COLLEGATA L'INGREDIENTE;
	@ManyToMany(mappedBy="ingredients")
	private List<Pizza> pizze;

	
	//GETTER - SETTER
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Pizza> getPizze() {
		return pizze;
	}

	public void setPizze(List<Pizza> pizze) {
		this.pizze = pizze;
	}
	
}
