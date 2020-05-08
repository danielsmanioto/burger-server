package com.dmanioto.burger.model;

import com.dmanioto.burger.model.enuns.IngredientType;
import lombok.*;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Ingredient {
	
	@Id
	private Long id;
	
	private String description;
	
	private BigDecimal price;

	public Ingredient(IngredientType e, BigDecimal price) {
		this.id = e.getId();
		this.description = e.getDescription();
		this.price = price;
	}
	
}
