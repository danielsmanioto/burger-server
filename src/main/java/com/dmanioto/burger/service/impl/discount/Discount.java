package com.dmanioto.burger.service.impl.discount;

import com.dmanioto.burger.model.OrderSale;

import java.math.BigDecimal;

@FunctionalInterface
public interface Discount {

    BigDecimal calculate(OrderSale os);

}
