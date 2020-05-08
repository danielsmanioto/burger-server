package com.dmanioto.burger.fixture.impl;

import com.dmanioto.burger.fixture.Fixture;
import com.dmanioto.burger.model.Burger;
import com.dmanioto.burger.model.Ingredient;
import com.dmanioto.burger.model.builder.BurgerBuilder;
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

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private BurgerRepository repository;

    @Override
    public void createPreDefinedData() {
        final Ingredient bacon = ingredientService.getBacon();
        final Ingredient meatBurger = ingredientService.getMeatBurger();
        final Ingredient cheese = ingredientService.getCheese();
        final Ingredient egg = ingredientService.getEgg();

        Burger xBacon = new BurgerBuilder().withType(BurgerType.X_BACON).withIngredients(Arrays.asList(bacon, meatBurger, cheese)).createBurger();
        repository.save(xBacon);

        Burger xBurger = new BurgerBuilder().withType(BurgerType.X_BURGER).withIngredients(Arrays.asList(meatBurger, cheese)).createBurger();
        repository.save(xBurger);

        Burger xEgg = new BurgerBuilder().withType(BurgerType.X_EGG).withIngredients(Arrays.asList(egg, meatBurger, cheese)).createBurger();
        repository.save(xEgg);

        Burger xEggBacon = new BurgerBuilder().withType(BurgerType.X_EGG_BACON).withIngredients(Arrays.asList(bacon, egg, meatBurger, cheese)).createBurger();
        repository.save(xEggBacon);

        log.info("Burgers created as success");
    }

}
