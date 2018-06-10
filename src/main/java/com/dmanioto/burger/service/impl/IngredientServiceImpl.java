package com.dmanioto.burger.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmanioto.burger.model.Ingredient;
import com.dmanioto.burger.model.Ingredient.IngredientEnum;
import com.dmanioto.burger.repository.IngredientRepository;
import com.dmanioto.burger.service.IngredientService;

@Service
public class IngredientServiceImpl implements IngredientService {

	@Autowired
	private IngredientRepository repository;

	@Override
	public void createPreDefinedIngredients() {
		repository.save(new Ingredient(IngredientEnum.LETTUCE, BigDecimal.valueOf(0.4)));
		repository.save(new Ingredient(IngredientEnum.BACON, BigDecimal.valueOf(2)));
		repository.save(new Ingredient(IngredientEnum.MEAT_BURGER, BigDecimal.valueOf(3)));
		repository.save(new Ingredient(IngredientEnum.EGG, BigDecimal.valueOf(0.8)));
		repository.save(new Ingredient(IngredientEnum.CHEESE, BigDecimal.valueOf(1.5)));
	}

	@Override
	public Ingredient getLettuce() {
		return repository.findById(IngredientEnum.LETTUCE.getId()).get();
	}

	@Override
	public Ingredient getBacon() {
		return repository.findById(IngredientEnum.BACON.getId()).get();
	}

	@Override
	public Ingredient getMeatBurger() {
		return repository.findById(IngredientEnum.MEAT_BURGER.getId()).get();
	}

	@Override
	public Ingredient getEgg() {
		return repository.findById(IngredientEnum.EGG.getId()).get();
	}

	@Override
	public Ingredient getCheese() {
		return repository.findById(IngredientEnum.CHEESE.getId()).get();
	}

	@Override
	public List<Ingredient> getAll() {
		return repository.findAll();
	}

}
