package com.dmanioto.burger.service.impl.discount;

import com.dmanioto.burger.model.Ingredient;
import com.dmanioto.burger.model.OrderSale;
import com.dmanioto.burger.model.enuns.IngredientType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DiscountLigthDiscountImpl implements Discount {

    @Override
    public BigDecimal calculate(OrderSale os) {
        long qttyLettuce = getCountForIngredient(os, IngredientType.LETTUCE);
        long qttyBacon = getCountForIngredient(os, IngredientType.BACON);

        final boolean isLight = qttyLettuce > 0 && qttyBacon == 0;
        return isLight ? os.getTotalPriceItens().multiply(BigDecimal.valueOf(0.10)) : BigDecimal.ZERO;
    }

    private long getCountForIngredient(OrderSale os, IngredientType lettuce) {
        return os.getItens()
                .stream()
                .filter(item -> lettuce.getId().equals(item.getIngredient().getId()))
                .count();
    }

}
