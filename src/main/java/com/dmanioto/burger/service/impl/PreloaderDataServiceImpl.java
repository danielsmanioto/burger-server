package com.dmanioto.burger.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmanioto.burger.service.BurgerService;
import com.dmanioto.burger.service.IngredientService;
import com.dmanioto.burger.service.PreloaderDataService;

@Service
public class PreloaderDataServiceImpl implements PreloaderDataService {

	@Autowired
	private IngredientService ingredientService;
	
	@Autowired
	private BurgerService burgerService;
	
	@Override
	public void persistAll() {
		ingredientService.createPreDefinedIngredients();
		burgerService.createPreDefinedBurgers();
	}
	
}
