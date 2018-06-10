package com.dmanioto.burger.service;

import java.math.BigDecimal;

import com.dmanioto.burger.model.OrderSale;

public interface PromotionDiscount {

	public BigDecimal getTotalPrice(OrderSale orderSale);
	
}
