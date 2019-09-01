package com.dmanioto.burger.fixture;

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
public class IngredientFixture {

    private final Logger LOG = LoggerFactory.getLogger(IngredientServiceImpl.class);

    @Autowired
    private IngredientRepository repository;

    public void createPreDefinedIngredients() {
        repository.save(new IngredientBuilder().setE(Ingredient.IngredientEnum.LETTUCE).setPrice(BigDecimal.valueOf(0.4)).createIngredient());
        repository.save(new IngredientBuilder().setE(Ingredient.IngredientEnum.BACON).setPrice(BigDecimal.valueOf(2)).createIngredient());
        repository.save(new IngredientBuilder().setE(Ingredient.IngredientEnum.MEAT_BURGER).setPrice(BigDecimal.valueOf(3)).createIngredient());
        repository.save(new IngredientBuilder().setE(Ingredient.IngredientEnum.EGG).setPrice(BigDecimal.valueOf(0.8)).createIngredient());
        repository.save(new IngredientBuilder().setE(Ingredient.IngredientEnum.CHEESE).setPrice(BigDecimal.valueOf(1.5)).createIngredient());

        LOG.info("Ingredients created as success.");
    }

}
