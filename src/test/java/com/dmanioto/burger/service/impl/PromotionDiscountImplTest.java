package com.dmanioto.burger.service.impl;

import com.dmanioto.burger.model.Ingredient;
import com.dmanioto.burger.model.OrderItem;
import com.dmanioto.burger.model.OrderSale;
import com.dmanioto.burger.service.PromotionDiscount;
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
public class PromotionDiscountImplTest {

    @Autowired
    private PromotionDiscount promotionDiscount;

    private Ingredient lettuce() {
        return Ingredient.builder().id(1L).description("Alface").price(new BigDecimal("0.40")).build();
    }

    private Ingredient bacon() {
        return Ingredient.builder().id(2L).description("Bacon").price(new BigDecimal("2.00")).build();
    }

    private Ingredient meatBurger() {
        return Ingredient.builder().id(3L).description("Hamburguer de Carne").price(new BigDecimal("3.00")).build();
    }

    private Ingredient cheese() {
        return Ingredient.builder().id(5L).description("Queijo").price(new BigDecimal("1.50")).build();
    }

    private OrderItem item(Ingredient ingredient) {
        return OrderItem.builder().ingredient(ingredient).priceSale(ingredient.getPrice()).build();
    }

    @Test
    public void noDiscountApplied() {
        OrderSale os = OrderSale.builder()
                .itens(Arrays.asList(item(bacon()), item(meatBurger())))
                .build();
        assertEquals(0, new BigDecimal("5.00").compareTo(promotionDiscount.calculeTotalPrice(os)));
    }

    @Test
    public void lightDiscountApplied() {
        OrderSale os = OrderSale.builder()
                .itens(Arrays.asList(item(lettuce()), item(meatBurger())))
                .build();
        BigDecimal total = new BigDecimal("3.40");
        BigDecimal discount = total.multiply(BigDecimal.valueOf(0.10));
        assertEquals(0, total.subtract(discount).compareTo(promotionDiscount.calculeTotalPrice(os)));
    }

    @Test
    public void meatDiscountApplied() {
        OrderSale os = OrderSale.builder()
                .itens(Arrays.asList(item(meatBurger()), item(meatBurger()), item(meatBurger())))
                .build();
        assertEquals(0, new BigDecimal("6.00").compareTo(promotionDiscount.calculeTotalPrice(os)));
    }

    @Test
    public void cheeseDiscountApplied() {
        OrderSale os = OrderSale.builder()
                .itens(Arrays.asList(item(cheese()), item(cheese()), item(cheese())))
                .build();
        assertEquals(0, new BigDecimal("3.00").compareTo(promotionDiscount.calculeTotalPrice(os)));
    }

}
