package com.dmanioto.burger.model.builder;

import com.dmanioto.burger.model.OrderDiscount;
import com.dmanioto.burger.model.OrderSale;

import java.math.BigDecimal;

public class OrderDiscountBuilder {
    private String description;
    private BigDecimal value;
    private OrderSale orderSale;

    public OrderDiscountBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public OrderDiscountBuilder withValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public OrderDiscountBuilder withOrderSale(OrderSale orderSale) {
        this.orderSale = orderSale;
        return this;
    }

    public OrderDiscount createOrderDiscount() {
        return new OrderDiscount(description, value, orderSale);
    }
}