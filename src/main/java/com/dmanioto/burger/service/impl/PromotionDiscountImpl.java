package com.dmanioto.burger.service.impl;

import java.math.BigDecimal;

import com.dmanioto.burger.model.Ingredient;
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
		long qttyLettuce = getCountForIngredient(os, IngredientEnum.LETTUCE);
		long qttyBacon = getCountForIngredient(os, IngredientEnum.BACON);
		long qttyCheese = getCountForIngredient(os, IngredientEnum.CHEESE);
		long qttyMeatBurger = getCountForIngredient(os, IngredientEnum.MEAT_BURGER);

		BigDecimal valueLigth = ligthDiscount(os.getTotalPriceItens(), qttyLettuce, qttyBacon);
		BigDecimal valueMeet = aLotOfMeatDiscount(qttyMeatBurger);
	  	BigDecimal valueCheese = aLotOfCheeseDiscount(qttyCheese);

		return valueLigth.add(valueMeet).add(valueCheese);
	}

	private long getCountForIngredient(OrderSale os, IngredientEnum lettuce) {
		return os.getItens()
				.stream()
				.filter(item -> lettuce.getId().equals(item.getIngredient().getId()))
				.count();
	}

	private BigDecimal ligthDiscount(BigDecimal totalPrice, long lettuce, long bacon) {
		final boolean isLight = lettuce > 0 && bacon == 0;
		return isLight ? totalPrice.multiply(BigDecimal.valueOf(0.10)) : BigDecimal.ZERO;
	}

	private BigDecimal aLotOfCheeseDiscount(long countCheese) {
		return ingredientService.getCheese().getPrice().multiply(BigDecimal.valueOf(countCheese / 3));
	}

	private BigDecimal aLotOfMeatDiscount(long countMetBurger) {
		return ingredientService.getMeatBurger().getPrice().multiply(BigDecimal.valueOf(countMetBurger / 3));
	}

}
