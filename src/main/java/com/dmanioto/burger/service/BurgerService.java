package com.dmanioto.burger.service;

import java.util.List;
import java.util.Optional;

import com.dmanioto.burger.model.Burger;

public interface BurgerService {

	Optional<Burger> getXBacon();

	Optional<Burger> getXBurger();

	Optional<Burger> getXEgg();

	Optional<Burger> getXEggBacon();

	List<Burger> findAll();

	Optional<Burger> getById(Long id);

}
