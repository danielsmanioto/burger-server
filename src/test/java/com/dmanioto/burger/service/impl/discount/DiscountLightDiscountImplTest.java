package com.dmanioto.burger.service.impl.discount;

import com.dmanioto.burger.model.Ingredient;
import com.dmanioto.burger.model.OrderItem;
import com.dmanioto.burger.model.OrderSale;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscountLightDiscountImplTest {

    @Autowired
    private DiscountLigthDiscountImpl discount;

    private Ingredient lettuce() {
        return Ingredient.builder().id(1L).description("Alface").price(new BigDecimal("0.40")).build();
    }

    private Ingredient bacon() {
        return Ingredient.builder().id(2L).description("Bacon").price(new BigDecimal("2.00")).build();
    }

    private Ingredient meatBurger() {
        return Ingredient.builder().id(3L).description("Hamburguer de Carne").price(new BigDecimal("3.00")).build();
    }

    private OrderItem item(Ingredient ingredient) {
        return OrderItem.builder().ingredient(ingredient).priceSale(ingredient.getPrice()).build();
    }

    @Test
    public void noDiscountWhenNoLettuceAndNoBacon() {
        OrderSale os = OrderSale.builder()
                .itens(Collections.singletonList(item(meatBurger())))
                .build();
        assertEquals(0, BigDecimal.ZERO.compareTo(discount.calculate(os)));
    }

    @Test
    public void noDiscountWhenLettuceAndBaconPresent() {
        OrderSale os = OrderSale.builder()
                .itens(Arrays.asList(item(lettuce()), item(bacon()), item(meatBurger())))
                .build();
        assertEquals(0, BigDecimal.ZERO.compareTo(discount.calculate(os)));
    }

    @Test
    public void discountAppliedWhenLettuceWithoutBacon() {
        OrderSale os = OrderSale.builder()
                .itens(Arrays.asList(item(lettuce()), item(meatBurger())))
                .build();
        BigDecimal expectedDiscount = os.getTotalPriceItens().multiply(BigDecimal.valueOf(0.10));
        assertEquals(0, expectedDiscount.compareTo(discount.calculate(os)));
    }

    @Test
    public void noDiscountWhenOnlyBacon() {
        OrderSale os = OrderSale.builder()
                .itens(Collections.singletonList(item(bacon())))
                .build();
        assertEquals(0, BigDecimal.ZERO.compareTo(discount.calculate(os)));
    }

}
