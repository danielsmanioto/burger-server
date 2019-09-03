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
		BigDecimal totalPrice = orderSale.getTotalPriceItens();

		BigDecimal totalDiscount = getTotalPriceDiscount(orderSale);

		return totalPrice.subtract(totalDiscount);
	}
	
	private BigDecimal getTotalPriceDiscount(OrderSale os) {
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
		
		BigDecimal valueLigth = ligthDiscount(os.getTotalPriceItens(), qttyLettuce, qttyBacon);
		BigDecimal valueMeet = aLotOfMeatDiscount(qttyMeatBurger);
	  	BigDecimal valueChees = aLotOfCheeseDiscount(qttyCheese);

		return valueLigth.add(valueMeet).add(valueChees);
	}

	private BigDecimal ligthDiscount(BigDecimal totalPrice, int lettuce, int bacon) {
		final boolean isLight = lettuce > 0 && bacon == 0;
		return isLight ? totalPrice.multiply(BigDecimal.valueOf(0.10)) : BigDecimal.ZERO;
	}

	private BigDecimal aLotOfCheeseDiscount(int countCheese) {
		return ingredientService.getCheese().getPrice().multiply(BigDecimal.valueOf(countCheese / 3));
	}

	private BigDecimal aLotOfMeatDiscount(int countMetBurger) {
		return ingredientService.getMeatBurger().getPrice().multiply(BigDecimal.valueOf(countMetBurger / 3));
	}

}
