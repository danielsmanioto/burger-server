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
public class DiscountALotOfCheeseDiscountImplTest {

    @Autowired
    private DiscountALotOfCheeseDiscountImpl discount;

    private Ingredient cheese() {
        return Ingredient.builder().id(5L).description("Queijo").price(new BigDecimal("1.50")).build();
    }

    private Ingredient meatBurger() {
        return Ingredient.builder().id(3L).description("Hamburguer de Carne").price(new BigDecimal("3.00")).build();
    }

    private OrderItem item(Ingredient ingredient) {
        return OrderItem.builder().ingredient(ingredient).priceSale(ingredient.getPrice()).build();
    }

    @Test
    public void noDiscountForLessThanThreeCheese() {
        OrderSale os = OrderSale.builder()
                .itens(Arrays.asList(item(cheese()), item(cheese())))
                .build();
        assertEquals(0, BigDecimal.ZERO.compareTo(discount.calculate(os)));
    }

    @Test
    public void discountAppliedForExactlyThreeCheese() {
        OrderSale os = OrderSale.builder()
                .itens(Arrays.asList(item(cheese()), item(cheese()), item(cheese())))
                .build();
        assertEquals(0, new BigDecimal("1.50").compareTo(discount.calculate(os)));
    }

    @Test
    public void noDiscountWithNoCheese() {
        OrderSale os = OrderSale.builder()
                .itens(Collections.singletonList(item(meatBurger())))
                .build();
        assertEquals(0, BigDecimal.ZERO.compareTo(discount.calculate(os)));
    }

    @Test
    public void discountAppliedForSixCheese() {
        OrderSale os = OrderSale.builder()
                .itens(Arrays.asList(
                        item(cheese()), item(cheese()), item(cheese()),
                        item(cheese()), item(cheese()), item(cheese())))
                .build();
        assertEquals(0, new BigDecimal("3.00").compareTo(discount.calculate(os)));
    }

}
