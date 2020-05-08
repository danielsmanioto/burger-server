package com.dmanioto.burger.model.builder;

import com.dmanioto.burger.model.Burger;
import com.dmanioto.burger.model.Ingredient;
import com.dmanioto.burger.model.enuns.BurgerType;

import java.util.List;

public class BurgerBuilder {
    private BurgerType e;
    private List<Ingredient> ingredients;

    public BurgerBuilder withType(BurgerType e) {
        this.e = e;
        return this;
    }

    public BurgerBuilder withIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
        return this;
    }

    public Burger createBurger() {
        return new Burger(e, ingredients);
    }
}