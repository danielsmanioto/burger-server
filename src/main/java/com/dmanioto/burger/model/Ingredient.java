package com.dmanioto.burger.model;

import lombok.*;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Ingredient {
	
	@Id
	private Long id;
	
	private String description;
	
	private BigDecimal price;

	public Ingredient(IngredientEnum e, BigDecimal price) {
		this.id = e.id;
		this.description = e.description;
		this.price = price;
	}

	public enum IngredientEnum {
		LETTUCE(1L, "Alface"), 
		BACON(2L, "Bacon"), 
		MEAT_BURGER(3L, "Hamburguer de Carne"), 
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
