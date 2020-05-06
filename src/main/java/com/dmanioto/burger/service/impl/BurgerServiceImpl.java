package com.dmanioto.burger.service.impl;

import com.dmanioto.burger.model.Burger;
import com.dmanioto.burger.model.Burger.BurgerEnum;
import com.dmanioto.burger.repository.BurgerRepository;
import com.dmanioto.burger.service.BurgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BurgerServiceImpl implements BurgerService {

	@Autowired
	private BurgerRepository repository;

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
	public List<Burger> findAll() {
		return repository.findAll();
	}

	@Override
	public Burger getById(Long id) {
		Optional<Burger> burger = repository.findById(id);
		return burger.isPresent() ? burger.get() : null;
	}
}
