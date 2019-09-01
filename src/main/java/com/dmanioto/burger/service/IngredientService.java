package com.dmanioto.burger.service;

import com.dmanioto.burger.model.Ingredient;

import java.util.List;

public interface IngredientService {

	Ingredient getLettuce();

	Ingredient getBacon();
	
	Ingredient getMeatBurger();
	
	Ingredient getEgg();
	
	Ingredient getCheese();

	List<Ingredient> getAll();

	Ingredient getById(Long id);
	
}
