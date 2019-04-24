package com.dmanioto.burger.model;

import com.dmanioto.burger.config.MessageResourceBundle;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Burger {
	
	@Id
	private Long id;

	private String description;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Ingredient> ingredients;

	public Burger() {
		// Constructor default
	}

	public Burger(BurgerEnum e, List<Ingredient> ingredients) {
		this.id = e.id;
		this.description = e.description;
		this.ingredients = ingredients;
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

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	public BigDecimal getPriceTotal() {
		double prince = 0;
		for(Ingredient i : ingredients) {
			prince += i.getPrice().doubleValue();
		}
		return BigDecimal.valueOf(prince);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ingredients == null) ? 0 : ingredients.hashCode());
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
		Burger other = (Burger) obj;
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
		if (ingredients == null) {
			if (other.ingredients != null)
				return false;
		} else if (!ingredients.equals(other.ingredients))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Burger [id=" + id + ", description=" + description + ", ingredients=" + ingredients + "]";
	}

	public enum BurgerEnum {
		X_BACON(1L, "X-Bacon"),
		X_BURGER(2L, "X-Burger"), 
		X_EGG(3L, "X-Egg"), 
		X_EGG_BACON(4L, "X-EggBacon");

		private final Long id;
		private final String description;

		BurgerEnum(Long id, String description) {
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
