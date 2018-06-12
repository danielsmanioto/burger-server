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
	public BigDecimal calculeTotalPrice(OrderSale orderSale) {
		double totalPrice = orderSale.getTotalPriceItens().doubleValue();
		
		double totalDiscount = getTotalPriceDiscount(orderSale, totalPrice);
		
		totalPrice -= totalDiscount;
		
		return BigDecimal.valueOf(totalPrice);
	}
	
	private double getTotalPriceDiscount(OrderSale os, double totalPrice) {
		int qttyLettuce = 0;
		int qttyBacon = 0;
		int qttyCheese = 0;
		int qttyMeatBurger = 0;
		
		for (OrderItem item : os.getItens()) {
			if (IngredientEnum.LETTUCE.getId().equals(item.getIngredient().getId()))
				qttyLettuce++;
			else if (IngredientEnum.BACON.getId().equals(item.getIngredient().getId()))
				qttyBacon++;
			else if (IngredientEnum.MEAT_BURGER.getId().equals(item.getIngredient().getId())) 
				qttyMeatBurger++;
			else if (IngredientEnum.CHEESE.getId().equals(item.getIngredient().getId())) 
				qttyCheese++;
		}
		
		double discount = 0;
		
		discount += ligthDiscount(totalPrice, discount, qttyLettuce, qttyBacon);
	  	discount += aLotOfMeatDiscount(qttyMeatBurger);
	  	discount += aLotOfCheeseDiscount(qttyCheese);
	  	
		return discount;
	}

	private double ligthDiscount(double totalPrice, double discount, int lettuce, int bacon) {
		final boolean isLight = lettuce > 0 && bacon == 0;
		if (isLight) {
			discount += totalPrice * 0.10;
		}
		
		return discount;
	}

	private double aLotOfCheeseDiscount(int countCheese) {
		return ingredientService.getCheese().getPrice().doubleValue() * (countCheese / 3);
	}

	private double aLotOfMeatDiscount(int countMetBurger) {
		return ingredientService.getMeatBurger().getPrice().doubleValue() * (countMetBurger / 3);
	}

}
