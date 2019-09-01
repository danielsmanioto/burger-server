package com.dmanioto.burger.fixture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmanioto.burger.service.BurgerService;
import com.dmanioto.burger.service.IngredientService;

@Service
public class MainPreloaderFixture {

	@Autowired
	private IngredientFixture ingredientFixture;

	@Autowired
	private BurgerFixture burgerFixture;

	public void persistAll() {
		ingredientFixture.createPreDefinedIngredients();
		burgerFixture.createPreDefinedBurgers();
	}
	
}
