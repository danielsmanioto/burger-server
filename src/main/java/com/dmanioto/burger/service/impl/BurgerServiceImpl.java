package com.dmanioto.burger.service.impl;

import com.dmanioto.burger.model.Burger;
import com.dmanioto.burger.model.enuns.BurgerType;
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
	public Optional<Burger> getXBacon() {
		return repository.findById(BurgerType.X_BACON.getId());
	}

	@Override
	public Optional<Burger> getXBurger() {
		return repository.findById(BurgerType.X_BURGER.getId());
	}

	@Override
	public Optional<Burger> getXEgg() {
		return repository.findById(BurgerType.X_EGG.getId());
	}

	@Override
	public Optional<Burger> getXEggBacon() {
		return repository.findById(BurgerType.X_EGG_BACON.getId());
	}

	@Override
	public List<Burger> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Burger> getById(Long id) {
		return repository.findById(id);
	}
}
