package com.dmanioto.burger.model.builder;

import com.dmanioto.burger.model.Ingredient;
import com.dmanioto.burger.model.OrderItem;

import java.math.BigDecimal;

public class OrderItemBuilder {
    private Ingredient ingredient;
    private BigDecimal price;

    public OrderItemBuilder withIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
        return this;
    }

    public OrderItemBuilder withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public OrderItem createOrderItem() {
        return new OrderItem(ingredient, price);
    }
}