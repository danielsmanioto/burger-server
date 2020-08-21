package com.dmanioto.burger.service.impl.discount;

import com.dmanioto.burger.model.OrderSale;
import com.dmanioto.burger.model.enuns.IngredientType;
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
        long qttyMeatBurger = getCountForIngredient(os, IngredientType.MEAT_BURGER);
        return ingredientService.getMeatBurger().getPrice().multiply(BigDecimal.valueOf(qttyMeatBurger / 3));
    }

    private long getCountForIngredient(OrderSale os, IngredientType lettuce) {
        Long leetBurgerId = 3L;
        return os.getItens()
                .stream()
                .filter(item -> leetBurgerId.equals(item.getIngredient().getId()))
                .count();
    }
}
