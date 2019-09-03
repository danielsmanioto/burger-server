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
		BigDecimal valueLigth = ligthDiscount(os);
		BigDecimal valueMeet = aLotOfMeatDiscount(os);
	  	BigDecimal valueCheese = aLotOfCheeseDiscount(os);

		return valueLigth.add(valueMeet).add(valueCheese);
	}

	private long getCountForIngredient(OrderSale os, IngredientEnum lettuce) {
		return os.getItens()
				.stream()
				.filter(item -> lettuce.getId().equals(item.getIngredient().getId()))
				.count();
	}

	private BigDecimal ligthDiscount(OrderSale os) {
		long qttyLettuce = getCountForIngredient(os, IngredientEnum.LETTUCE);
		long qttyBacon = getCountForIngredient(os, IngredientEnum.BACON);

		final boolean isLight = qttyLettuce > 0 && qttyBacon == 0;
		return isLight ? os.getTotalPriceItens().multiply(BigDecimal.valueOf(0.10)) : BigDecimal.ZERO;
	}

	private BigDecimal aLotOfCheeseDiscount(OrderSale os) {
		long qttyCheese = getCountForIngredient(os, IngredientEnum.CHEESE);
		return ingredientService.getCheese().getPrice().multiply(BigDecimal.valueOf(qttyCheese / 3));
	}

	private BigDecimal aLotOfMeatDiscount(OrderSale os) {
		long qttyMeatBurger = getCountForIngredient(os, IngredientEnum.MEAT_BURGER);
		return ingredientService.getMeatBurger().getPrice().multiply(BigDecimal.valueOf(qttyMeatBurger / 3));
	}

}
