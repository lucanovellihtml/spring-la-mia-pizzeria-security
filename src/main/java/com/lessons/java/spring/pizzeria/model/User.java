package com.lessons.java.spring.pizzeria.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;


//ENTITA' USER PER L'AUTENTICAZIONE
@Entity
public class User {

	@Id
	private Integer id;
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	//EAGER ---> RECUPERO DI TUTTI I RUOLI CONNESSI ALL'UTENTE;
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Role> roles;

	
	//GETTER - SETTER
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
