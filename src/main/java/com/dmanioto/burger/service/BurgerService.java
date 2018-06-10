package com.dmanioto.burger.service;

import java.util.List;

import com.dmanioto.burger.model.Burger;

public interface BurgerService {

	Burger getXBacon();

	Burger getXBurger();

	Burger getXEgg();

	Burger getXEggBacon();

	void createPreDefinedBurgers();

	List<Burger> getAll();

}
