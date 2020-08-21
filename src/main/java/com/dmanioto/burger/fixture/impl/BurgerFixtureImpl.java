package com.dmanioto.burger.fixture.impl;

import com.dmanioto.burger.fixture.Fixture;
import com.dmanioto.burger.model.Burger;
import com.dmanioto.burger.model.Ingredient;
import com.dmanioto.burger.model.enuns.BurgerType;
import com.dmanioto.burger.repository.BurgerRepository;
import com.dmanioto.burger.service.IngredientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class BurgerFixtureImpl implements Fixture {

    private final IngredientService ingredientService;

    private final BurgerRepository burgerRepository;

    @Autowired
    public BurgerFixtureImpl(IngredientService ingredientService, BurgerRepository repository) {
        this.ingredientService = ingredientService;
        this.burgerRepository = repository;
    }

    @Override
    public void createPreDefinedData() {
        final Ingredient bacon = ingredientService.getBacon();
        final Ingredient meatBurger = ingredientService.getMeatBurger();
        final Ingredient cheese = ingredientService.getCheese();
        final Ingredient egg = ingredientService.getEgg();

        Burger xBacon = Burger.builder()
                .id(BurgerType.X_BACON.getId())
                .description(BurgerType.X_BACON.getDescription())
                .ingredients(Arrays.asList(bacon, meatBurger, cheese)).build();
        burgerRepository.save(xBacon);

        Burger xBurger = Burger.builder()
                .id(BurgerType.X_BURGER.getId())
                .description(BurgerType.X_BURGER.getDescription())
                .ingredients(Arrays.asList( meatBurger, cheese)).build();
        burgerRepository.save(xBurger);

        Burger xEgg = Burger.builder()
                .id(BurgerType.X_EGG.getId())
                .description(BurgerType.X_EGG.getDescription())
                .ingredients(Arrays.asList(egg, meatBurger, cheese)).build();
        burgerRepository.save(xEgg);

        Burger xEggBacon = Burger.builder()
                .id(BurgerType.X_EGG_BACON.getId())
                .description(BurgerType.X_EGG_BACON.getDescription())
                .ingredients(Arrays.asList(bacon, egg, meatBurger, cheese)).build();
        burgerRepository.save(xEggBacon);

        log.info("Burgers created as success");
    }

}
