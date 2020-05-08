package com.dmanioto.burger.model.enuns;

public enum IngredientType {
	LETTUCE(1L, "Alface"),
	BACON(2L, "Bacon"),
	MEAT_BURGER(3L, "Hamburguer de Carne"),
	EGG(4L, "Ovo"),
	CHEESE(5L, "Queijo");
	
	private final Long id;
	private final String description;
	
	IngredientType(Long id, String description) {
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
