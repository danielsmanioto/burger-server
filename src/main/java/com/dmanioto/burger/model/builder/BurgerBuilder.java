package com.dmanioto.burger.model.builder;

import com.dmanioto.burger.model.Burger;
import com.dmanioto.burger.model.Ingredient;

import java.util.List;

public class BurgerBuilder {
    private Burger.BurgerEnum e;
    private List<Ingredient> ingredients;

    public BurgerBuilder withType(Burger.BurgerEnum e) {
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