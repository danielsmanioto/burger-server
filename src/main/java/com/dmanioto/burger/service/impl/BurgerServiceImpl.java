package com.dmanioto.burger.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmanioto.burger.model.Burger;
import com.dmanioto.burger.model.Burger.BurgerEnum;
import com.dmanioto.burger.repository.BurgerRepository;
import com.dmanioto.burger.service.BurgerService;

@Service
public class BurgerServiceImpl implements BurgerService {
	
	//private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BurgerRepository repository;
	
	@Autowired
	private IngredientServiceImpl ingredientService;
	
	/*
	 * TODO
	 * 
	 * Refatorar por favor
	 * 
	 * */
	@Override
	public void createPreDefinedBurgers() {
		Burger xBacon = new Burger(BurgerEnum.X_BACON, 
				Arrays.asList(ingredientService.getBacon(), ingredientService.getMeatBurger(), ingredientService.getCheese()));
		repository.save(xBacon);
		
		Burger xBurger = new Burger(BurgerEnum.X_BURGER, 
				Arrays.asList(ingredientService.getMeatBurger(), ingredientService.getCheese()));
		repository.save(xBurger);

		Burger xEgg = new Burger(BurgerEnum.X_EGG, 
				Arrays.asList(ingredientService.getEgg(),  ingredientService.getMeatBurger(),  ingredientService.getCheese()));
		repository.save(xEgg);
		
		Burger xEggBacon = new Burger(BurgerEnum.X_EGG_BACON, 
				Arrays.asList(ingredientService.getBacon(), ingredientService.getEgg(),  ingredientService.getMeatBurger(),  ingredientService.getCheese()));
		repository.save(xEggBacon);
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
	
}
