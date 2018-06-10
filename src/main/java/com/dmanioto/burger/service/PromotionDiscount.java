package com.dmanioto.burger.service;

import java.math.BigDecimal;
import java.util.List;

import com.dmanioto.burger.model.OrderItem;
import com.dmanioto.burger.model.OrderSale;

public interface PromotionDiscount {
	
	double getDiscountLigth(List<OrderItem> itens, OrderSale os, double totalPrice);

	BigDecimal getTotalPrice(List<OrderItem> itens, OrderSale os);
	
}
