package com.dmanioto.burger.model.builder;

import com.dmanioto.burger.model.Ingredient;
import com.dmanioto.burger.model.enuns.IngredientType;

import java.math.BigDecimal;

public class IngredientBuilder {
    private IngredientType e;
    private BigDecimal price;

    public IngredientBuilder withType(IngredientType e) {
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