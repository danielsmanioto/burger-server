package com.dmanioto.burger.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmanioto.burger.service.PreloaderDataService;

@Service
public class PreloaderDataServiceImpl implements PreloaderDataService {

	@Autowired
	private IngredientServiceImpl ingredientService;
	
	@Autowired
	private BurgerServiceImpl burgerService;
	
	@Override
	public void persistAll() {
		ingredientService.createPreDefinedIngredients();
		burgerService.createPreDefinedBurgers();
	}
	
	
}
