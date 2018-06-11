package com.dmanioto.burger.service;

import java.util.List;

import com.dmanioto.burger.model.Ingredient;

public interface IngredientService {

	void createPreDefinedIngredients();

	Ingredient getLettuce();

	Ingredient getBacon();
	
	Ingredient getMeatBurger();
	
	Ingredient getEgg();
	
	Ingredient getCheese();

	List<Ingredient> getAll();

	Ingredient getById(Long id);
	
}
