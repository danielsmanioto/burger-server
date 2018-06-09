package com.dmanioto.burger.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Ingredient {
	
	@Id
	private Long id;
	
	private String description;
	
	private BigDecimal price;
	
	@JsonIgnore
	@ManyToOne
	private Burger burger;
	
	public Ingredient() {
		// Constructor default
	}
	
	public Ingredient(IngredientEnum e, BigDecimal price) {
		this.id = e.id;
		this.description = e.description;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Burger getBurger() {
		return burger;
	}

	public void setBurger(Burger burger) {
		this.burger = burger;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", description=" + description + ", price=" + price + ", burger=" + burger
				+ "]";
	}
	
	public enum IngredientEnum {
		LETTUCE(1L, "LETTUCE"), 
		BACON(2L, "BACON"), 
		MEAT_BURGER(3L, "MEAT BURGER"), 
		EGG(4L, "EGG"), 
		CHEESE(5L, "CHEESE");

		private final Long id;
		private final String description;

		IngredientEnum(Long id, String description) {
			this.id = id;
			this.description = description;
		}

		public Long getId() {
			return id;
		}

		public String getDescription() {
			return description;
		}
	}
	
}
