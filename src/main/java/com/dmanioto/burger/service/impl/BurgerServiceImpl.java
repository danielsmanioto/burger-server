package com.dmanioto.burger.service.impl;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmanioto.burger.model.Burger;
import com.dmanioto.burger.model.Burger.BurgerEnum;
import com.dmanioto.burger.model.Ingredient;
import com.dmanioto.burger.repository.BurgerRepository;
import com.dmanioto.burger.service.BurgerService;
import com.dmanioto.burger.service.IngredientService;

@Service
public class BurgerServiceImpl implements BurgerService {

	private final Logger LOG = LoggerFactory.getLogger(BurgerServiceImpl.class);

	@Autowired
	private BurgerRepository repository;

	@Autowired
	private IngredientService ingredientService;

	@Override
	public void createPreDefinedBurgers() {
		final Ingredient bacon = ingredientService.getBacon();
		final Ingredient meatBurger = ingredientService.getMeatBurger();
		final Ingredient cheese = ingredientService.getCheese();
		final Ingredient egg = ingredientService.getEgg();

		Burger xBacon = new Burger(BurgerEnum.X_BACON, Arrays.asList(bacon, meatBurger, cheese));
		repository.save(xBacon);

		Burger xBurger = new Burger(BurgerEnum.X_BURGER, Arrays.asList(meatBurger, cheese));
		repository.save(xBurger);

		Burger xEgg = new Burger(BurgerEnum.X_EGG, Arrays.asList(egg, meatBurger, cheese));
		repository.save(xEgg);

		Burger xEggBacon = new Burger(BurgerEnum.X_EGG_BACON, Arrays.asList(bacon, egg, meatBurger, cheese));
		repository.save(xEggBacon);

		LOG.info("Burgers created as success");
	}

	@Override
	public Burger getXBacon() {
		return repository.findById(BurgerEnum.X_BACON.getId()).get();
	}

	@Override
	public Burger getXBurger() {
		return repository.findById(BurgerEnum.X_BURGER.getId()).get();
	}

	@Override
	public Burger getXEgg() {
		return repository.findById(BurgerEnum.X_EGG.getId()).get();
	}

	@Override
	public Burger getXEggBacon() {
		return repository.findById(BurgerEnum.X_EGG_BACON.getId()).get();
	}

	@Override
	public List<Burger> getAll() {
		return repository.findAll();
	}

	@Override
	public Burger getById(Long id) {
		return repository.findById(id).get();
	}

}
