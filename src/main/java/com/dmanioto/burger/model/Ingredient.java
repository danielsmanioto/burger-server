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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((burger == null) ? 0 : burger.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ingredient other = (Ingredient) obj;
		if (burger == null) {
			if (other.burger != null)
				return false;
		} else if (!burger.equals(other.burger))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ingredient [id=" + id + ", description=" + description + ", price=" + price + ", burger=" + burger
				+ "]";
	}
	
	public enum IngredientEnum {
		LETTUCE(1L, "Alface"), 
		BACON(2L, "Bacon"), 
		MEAT_BURGER(3L, "Hamburger de Carne"), 
		EGG(4L, "Ovo"), 
		CHEESE(5L, "Queijo");
		
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
