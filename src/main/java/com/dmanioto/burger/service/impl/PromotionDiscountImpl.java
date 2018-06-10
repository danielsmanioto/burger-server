package com.dmanioto.burger.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dmanioto.burger.model.OrderItem;
import com.dmanioto.burger.model.OrderSale;
import com.dmanioto.burger.model.Ingredient.IngredientEnum;
import com.dmanioto.burger.service.PromotionDiscount;

@Service
public class PromotionDiscountImpl implements PromotionDiscount {

	@Override
	public double getDiscountLigth(List<OrderItem> itens, OrderSale os, double totalPrice) {
		double discount = 0;
		int lettuce = 0;
		int bacon = 0;
		for (OrderItem item : itens) {
			if (IngredientEnum.LETTUCE.equals(item.getIngredient()))
				lettuce++;
			else if (IngredientEnum.BACON.equals(item.getIngredient()))
				bacon++;
		}

		if (lettuce > 0 && bacon == 0) {
			discount = totalPrice * 0.10;
		}
		return discount;
	}

	@Override
	public BigDecimal getTotalPrice(List<OrderItem> itens, OrderSale os) {
		double totalPrice = os.getTotalPriceItens().doubleValue();
		
		double totalDiscount = getDiscountLigth(itens, os, totalPrice);
		
		totalPrice -= totalDiscount;
		
		return BigDecimal.valueOf(totalPrice);
	}

}
