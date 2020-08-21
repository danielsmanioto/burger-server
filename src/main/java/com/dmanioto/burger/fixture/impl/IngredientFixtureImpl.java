package com.dmanioto.burger.fixture.impl;

import com.dmanioto.burger.fixture.Fixture;
import com.dmanioto.burger.model.Ingredient;
import com.dmanioto.burger.repository.IngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Slf4j
@Component
public class IngredientFixtureImpl implements Fixture {

    private final IngredientRepository repository;

    @Autowired
    public IngredientFixtureImpl(IngredientRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createPreDefinedData() {
       Ingredient lettuce = Ingredient.builder()
                .id(1L)
                .description("Alface")
                .price(new BigDecimal("0.40"))
                .build();
        repository.save(lettuce);

        Ingredient bacon = Ingredient.builder()
                .id(2L)
                .description("Bacon")
                .price(new BigDecimal("2.0"))
                .build();
        repository.save(bacon);

        Ingredient meatBurger = Ingredient.builder()
                .id(3L)
                .description("Hamburguer de Carne")
                .price(new BigDecimal("3.0"))
                .build();
        repository.save(meatBurger);

        Ingredient egg = Ingredient.builder()
                .id(4L)
                .description("Ovo")
                .price(new BigDecimal("0.8"))
                .build();
        repository.save(egg);

        Ingredient cheese = Ingredient.builder()
                .id(5L)
                .description("Queijo")
                .price(new BigDecimal("1.50"))
                .build();
        repository.save(cheese);

        log.info("Ingredients created as success.");
    }

}
