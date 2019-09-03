package com.dmanioto.burger.service.impl.discount;

import com.dmanioto.burger.model.Ingredient;
import com.dmanioto.burger.model.OrderSale;
import com.dmanioto.burger.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DiscountALotOfMeatDiscountImpl implements Discount {

    @Autowired
    private IngredientService ingredientService;

    @Override
    public BigDecimal calculate(OrderSale os) {
        long qttyMeatBurger = getCountForIngredient(os, Ingredient.IngredientEnum.MEAT_BURGER);
        return ingredientService.getMeatBurger().getPrice().multiply(BigDecimal.valueOf(qttyMeatBurger / 3));
    }

    private long getCountForIngredient(OrderSale os, Ingredient.IngredientEnum lettuce) {
        return os.getItens()
                .stream()
                .filter(item -> lettuce.getId().equals(item.getIngredient().getId()))
                .count();
    }
}