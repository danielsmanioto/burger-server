package com.dmanioto.burger.fixture;

import com.dmanioto.burger.model.Burger;
import com.dmanioto.burger.model.Ingredient;
import com.dmanioto.burger.model.builder.BurgerBuilder;
import com.dmanioto.burger.repository.BurgerRepository;
import com.dmanioto.burger.service.IngredientService;
import com.dmanioto.burger.service.impl.BurgerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BurgerFixture {

    private final Logger LOG = LoggerFactory.getLogger(BurgerServiceImpl.class);

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private BurgerRepository repository;

    public void createPreDefinedBurgers() {
        final Ingredient bacon = ingredientService.getBacon();
        final Ingredient meatBurger = ingredientService.getMeatBurger();
        final Ingredient cheese = ingredientService.getCheese();
        final Ingredient egg = ingredientService.getEgg();

        Burger xBacon = new BurgerBuilder().setE(Burger.BurgerEnum.X_BACON).setIngredients(Arrays.asList(bacon, meatBurger, cheese)).createBurger();
        repository.save(xBacon);

        Burger xBurger = new BurgerBuilder().setE(Burger.BurgerEnum.X_BURGER).setIngredients(Arrays.asList(meatBurger, cheese)).createBurger();
        repository.save(xBurger);

        Burger xEgg = new BurgerBuilder().setE(Burger.BurgerEnum.X_EGG).setIngredients(Arrays.asList(egg, meatBurger, cheese)).createBurger();
        repository.save(xEgg);

        Burger xEggBacon = new BurgerBuilder().setE(Burger.BurgerEnum.X_EGG_BACON).setIngredients(Arrays.asList(bacon, egg, meatBurger, cheese)).createBurger();
        repository.save(xEggBacon);

        LOG.info("Burgers created as success");
    }

}
