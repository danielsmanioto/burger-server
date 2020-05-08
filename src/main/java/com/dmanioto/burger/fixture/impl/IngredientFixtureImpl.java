package com.dmanioto.burger.fixture.impl;

import com.dmanioto.burger.fixture.Fixture;
import com.dmanioto.burger.model.Ingredient;
import com.dmanioto.burger.model.builder.IngredientBuilder;
import com.dmanioto.burger.model.enuns.IngredientType;
import com.dmanioto.burger.repository.IngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
public class IngredientFixtureImpl implements Fixture {

    @Autowired
    private IngredientRepository repository;

    @Override
    public void createPreDefinedData() {
        repository.save(new IngredientBuilder().withType(IngredientType.LETTUCE).withPrice(BigDecimal.valueOf(0.4)).createIngredient());
        repository.save(new IngredientBuilder().withType(IngredientType.BACON).withPrice(BigDecimal.valueOf(2)).createIngredient());
        repository.save(new IngredientBuilder().withType(IngredientType.MEAT_BURGER).withPrice(BigDecimal.valueOf(3)).createIngredient());
        repository.save(new IngredientBuilder().withType(IngredientType.EGG).withPrice(BigDecimal.valueOf(0.8)).createIngredient());
        repository.save(new IngredientBuilder().withType(IngredientType.CHEESE).withPrice(BigDecimal.valueOf(1.5)).createIngredient());
        
        log.info("Ingredients created as success.");
    }

}
