package com.dmanioto.burger.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmanioto.burger.model.OrderItem;
import com.dmanioto.burger.model.OrderSale;
import com.dmanioto.burger.model.Ingredient.IngredientEnum;
import com.dmanioto.burger.service.IngredientService;
import com.dmanioto.burger.service.PromotionDiscount;

@Service
public class PromotionDiscountImpl implements PromotionDiscount {

	@Autowired
	private IngredientService ingredientService;
	
	@Override
	public BigDecimal getTotalPrice(OrderSale orderSale) {
		double totalPrice = orderSale.getTotalPriceItens().doubleValue();
		
		double totalDiscount = getValue(orderSale, totalPrice);
		
		totalPrice -= totalDiscount;
		
		return BigDecimal.valueOf(totalPrice);
	}
	
	private double getValue(OrderSale os, double totalPrice) {
		double discount = 0;
		
		int lettuce = 0;
		int bacon = 0;
		
		int countCheese = 0;
		int countMetBurger = 0;
		
		for (OrderItem item : os.getItens()) {
			if (IngredientEnum.LETTUCE.getId().equals(item.getIngredient().getId()))
				lettuce++;
			else if (IngredientEnum.BACON.getId().equals(item.getIngredient().getId()))
				bacon++;
			else if (IngredientEnum.MEAT_BURGER.getId().equals(item.getIngredient().getId())) 
				countMetBurger++;
			else if (IngredientEnum.CHEESE.getId().equals(item.getIngredient().getId())) 
				countCheese++;
		}
		
	  	discount += ingredientService.getMeatBurger().getPrice().doubleValue() * (countMetBurger / 3);

	  	discount += ingredientService.getCheese().getPrice().doubleValue() * (countCheese / 3);
	  	
	  	if (isLigth(lettuce, bacon)) {
			discount += totalPrice * 0.10;
		}
	  	
		return discount;
	}

	private boolean isLigth(int lettuce, int bacon) {
		return lettuce > 0 && bacon == 0;
	}

}
