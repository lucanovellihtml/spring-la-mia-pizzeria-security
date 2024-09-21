package com.lessons.java.spring.pizzeria.model;

import java.time.LocalDateTime;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


//ENTITA' PIZZA;
@Entity
@Table(name = "pizze")
public class Pizza {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Size(min=2, max=255)
	private String name;
	
	@NotNull
	@Size(min=2, max=255)
	private String description;
	
	private String photo;
	
	@NotNull
	@Min(1)
	private double price;
	
	// 1 - LA RELAZIONE E' UNO A MOLTI, DOVE UNA PIZZA PUO' AVERE PIU' SCONTI E QUINDI C'E' UNA LISTA;
	//POSSIAMO STABILIRE NELLA RELAZIONE CHE UNA VOLTA RIMOSSA L'ENTITA', TUTTE LE RELAZIONI CONNESSE ALLA PIZZA ANDRANNO PERSE (CASCADE);
	//DENTRO AL "mappedBy" FACCIO RIFERIMENTO ALLA VARIABILE D'ISTANZA CHE E' PRESENTE NELL'ENTITA' A CUI E' COLLEGATA PIZZA;
	@OneToMany(mappedBy = "pizza", cascade = {CascadeType.REMOVE} )
	private List<Discount> discounts;
	
	
	// 2 - LA RELAZIONE E' MOLTI A MOLTI, DOVE UNA PIZZA PUO' AVERE PIU' INGREDIENTI E QUINDI C'E' UNA LISTA;
	@ManyToMany()
	@JoinTable(
		name = "pizza_ingredient",
		joinColumns = @JoinColumn(name = "pizza_id"),
		inverseJoinColumns = @JoinColumn(name = "ingredient_id")
	)
	private List<Ingredient> ingredients;
	
	
	private LocalDateTime updateAt;

	
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}

	public List<Discount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<Discount> discounts) {
		this.discounts = discounts;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
}
