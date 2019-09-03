package com.dmanioto.burger.service.impl.discount;

import com.dmanioto.burger.model.Ingredient;
import com.dmanioto.burger.model.OrderSale;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DiscountLigthDiscountImpl implements Discount {

    @Override
    public BigDecimal calculate(OrderSale os) {
        long qttyLettuce = getCountForIngredient(os, Ingredient.IngredientEnum.LETTUCE);
        long qttyBacon = getCountForIngredient(os, Ingredient.IngredientEnum.BACON);

        final boolean isLight = qttyLettuce > 0 && qttyBacon == 0;
        return isLight ? os.getTotalPriceItens().multiply(BigDecimal.valueOf(0.10)) : BigDecimal.ZERO;
    }

    private long getCountForIngredient(OrderSale os, Ingredient.IngredientEnum lettuce) {
        return os.getItens()
                .stream()
                .filter(item -> lettuce.getId().equals(item.getIngredient().getId()))
                .count();
    }

}
