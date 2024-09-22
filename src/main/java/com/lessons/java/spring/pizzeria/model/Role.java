package com.lessons.java.spring.pizzeria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

//ENTITA' ROLE PER L'AUTENTICAZIONE
@Entity
public class Role {

	@Id
	private Integer id;

	@NotNull
	private String name;

	// GETTER - SETTER
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

}
