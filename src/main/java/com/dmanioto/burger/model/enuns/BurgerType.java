package com.dmanioto.burger.model.enuns;

public enum BurgerType {
	X_BACON(1L, "X-Bacon"),
	X_BURGER(2L, "X-Burger"),
	X_EGG(3L, "X-Egg"),
	X_EGG_BACON(4L, "X-EggBacon");
	
	private final Long id;
	private final String description;
	
	BurgerType(Long id, String description) {
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
