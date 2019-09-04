package com.dmanioto.burger.model.builder;

import com.dmanioto.burger.model.Ingredient;

import java.math.BigDecimal;

public class IngredientBuilder {
    private Ingredient.IngredientEnum e;
    private BigDecimal price;

    public IngredientBuilder withType(Ingredient.IngredientEnum e) {
        this.e = e;
        return this;
    }

    public IngredientBuilder withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Ingredient createIngredient() {
        return new Ingredient(e, price);
    }
}