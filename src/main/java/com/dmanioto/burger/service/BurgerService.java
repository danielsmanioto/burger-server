package com.dmanioto.burger.service;

import com.dmanioto.burger.model.Burger;

public interface BurgerService {

	Burger getXBacon();

	Burger getXBurger();

	Burger getXEgg();

	Burger getXEggBacon();

	void createPreDefinedBurgers();

}
