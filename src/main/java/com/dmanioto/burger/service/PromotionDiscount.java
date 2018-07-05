package com.dmanioto.burger.service;

import java.math.BigDecimal;

import com.dmanioto.burger.model.OrderSale;

public interface PromotionDiscount {

	BigDecimal calculeTotalPrice(OrderSale orderSale);
	
}
