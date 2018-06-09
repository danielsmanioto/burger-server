package com.dmanioto.burger.service;

import com.dmanioto.burger.model.Ingredient;

public interface IngredientService {

	void createPreDefinedIngredients();

	Ingredient getLettuce();

	Ingredient getBacon();
	
	Ingredient getMeatBurger();
	
	Ingredient getEgg();
	
	Ingredient getCheese();
	
	
}
