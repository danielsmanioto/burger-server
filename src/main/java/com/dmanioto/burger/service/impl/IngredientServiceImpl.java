package com.dmanioto.burger.service.impl;

import com.dmanioto.burger.model.Ingredient;
import com.dmanioto.burger.model.Ingredient.IngredientEnum;
import com.dmanioto.burger.repository.IngredientRepository;
import com.dmanioto.burger.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

	@Autowired
	private IngredientRepository repository;

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

	@Override
	public Ingredient getById(Long id) {
		return repository.findById(id).get();
	}

}
