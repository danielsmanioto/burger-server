package com.dmanioto.burger.service.impl.discount;

import com.dmanioto.burger.model.OrderSale;
import com.dmanioto.burger.model.enuns.IngredientType;
import com.dmanioto.burger.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DiscountALotOfCheeseDiscountImpl implements Discount  {

    @Autowired
    private IngredientService ingredientService;

    @Override
    public BigDecimal calculate(OrderSale os) {
        long qttyCheese = getCountForIngredient(os, IngredientType.CHEESE);
        return ingredientService.getCheese().getPrice().multiply(BigDecimal.valueOf(qttyCheese / 3));
    }

    private long getCountForIngredient(OrderSale os,IngredientType lettuce) {
        return os.getItens()
                .stream()
                .filter(item -> lettuce.getId().equals(item.getIngredient().getId()))
                .count();
    }

}
