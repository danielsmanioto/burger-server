package com.dmanioto.burger.service.impl;

import com.dmanioto.burger.model.Ingredient;
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
		return repository.findById(1L).get();
	}

	@Override
	public Ingredient getBacon() {
		return repository.findById(2L).get();
	}

	@Override
	public Ingredient getMeatBurger() {
		return repository.findById(3L).get();
	}

	@Override
	public Ingredient getEgg() {
		return repository.findById(4L).get();
	}

	@Override
	public Ingredient getCheese() {
		return repository.findById(5L).get();
	}

	@Override
	public List<Ingredient> findAll() {
		return repository.findAll();
	}

	@Override
	public Ingredient getById(Long id) {
		return repository.findById(id).get();
	}

}
