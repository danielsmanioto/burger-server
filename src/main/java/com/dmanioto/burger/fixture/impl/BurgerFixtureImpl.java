package com.dmanioto.burger.fixture.impl;

import com.dmanioto.burger.fixture.Fixture;
import com.dmanioto.burger.model.Burger;
import com.dmanioto.burger.model.Ingredient;
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
                .id(1L)
                .description("X-Bacon")
                .ingredients(Arrays.asList(bacon, meatBurger, cheese)).build();
        burgerRepository.save(xBacon);

        Burger xBurger = Burger.builder()
                .id(2L)
                .description("X-Bacon")
                .ingredients(Arrays.asList( meatBurger, cheese)).build();
        burgerRepository.save(xBurger);

        Burger xEgg = Burger.builder()
                .id(3L)
                .description("X-Egg")
                .ingredients(Arrays.asList(egg, meatBurger, cheese)).build();
        burgerRepository.save(xEgg);

        Burger xEggBacon = Burger.builder()
                .id(4L)
                .description("X-Egg-Bacon")
                .ingredients(Arrays.asList(bacon, egg, meatBurger, cheese)).build();
        burgerRepository.save(xEggBacon);

        log.info("Burgers created as success");
    }

}
