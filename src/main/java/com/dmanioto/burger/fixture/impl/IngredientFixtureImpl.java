package com.dmanioto.burger.fixture.impl;

import com.dmanioto.burger.fixture.Fixture;
import com.dmanioto.burger.model.Ingredient;
import com.dmanioto.burger.model.builder.IngredientBuilder;
import com.dmanioto.burger.repository.IngredientRepository;
import com.dmanioto.burger.service.impl.IngredientServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class IngredientFixtureImpl implements Fixture {

    private final Logger LOG = LoggerFactory.getLogger(IngredientServiceImpl.class);

    @Autowired
    private IngredientRepository repository;

    @Override
    public void createPreDefinedData() {
        repository.save(new IngredientBuilder().withType(Ingredient.IngredientEnum.LETTUCE).withPrice(BigDecimal.valueOf(0.4)).createIngredient());
        repository.save(new IngredientBuilder().withType(Ingredient.IngredientEnum.BACON).withPrice(BigDecimal.valueOf(2)).createIngredient());
        repository.save(new IngredientBuilder().withType(Ingredient.IngredientEnum.MEAT_BURGER).withPrice(BigDecimal.valueOf(3)).createIngredient());
        repository.save(new IngredientBuilder().withType(Ingredient.IngredientEnum.EGG).withPrice(BigDecimal.valueOf(0.8)).createIngredient());
        repository.save(new IngredientBuilder().withType(Ingredient.IngredientEnum.CHEESE).withPrice(BigDecimal.valueOf(1.5)).createIngredient());

        LOG.info("Ingredients created as success.");
    }

}
