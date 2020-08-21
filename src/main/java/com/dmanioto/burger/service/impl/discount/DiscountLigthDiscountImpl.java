package com.dmanioto.burger.service.impl.discount;

import com.dmanioto.burger.model.OrderSale;
import com.dmanioto.burger.model.enuns.IngredientType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DiscountLigthDiscountImpl implements Discount {

    @Override
    public BigDecimal calculate(OrderSale os) {
        Long lettuceId = 1L;
        Long baconId = 2L;

        long qttyLettuce = getCountForIngredient(os, lettuceId);
        long qttyBacon = getCountForIngredient(os, baconId);

        final boolean isLight = qttyLettuce > 0 && qttyBacon == 0;
        return isLight ? os.getTotalPriceItens().multiply(BigDecimal.valueOf(0.10)) : BigDecimal.ZERO;
    }

    private long getCountForIngredient(OrderSale os, Long idIngredientType) {
        return os.getItens()
                .stream()
                .filter(item -> idIngredientType.equals(item.getIngredient().getId()))
                .count();
    }


}
