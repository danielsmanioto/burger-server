package com.dmanioto.burger.service.impl;

import java.math.BigDecimal;

import com.dmanioto.burger.model.Ingredient;

/* TODO 
	Muita carne
	
	A cada 3 porções de carne o cliente só paga 2. Se o lanche tiver 6 porções, ocliente pagará 4. Assim por diante...
	
	Muito queijo
	
	A cada 3 porções de queijo o cliente só paga 2. Se o lanche tiver 6 porções, ocliente pagará 4. Assim por diante...
*/

public class PromotionDiscountEachThreeOneFree {
	
	public BigDecimal getValueDiscount(Ingredient ingredient, int count) {
		Long discont = count / Long.valueOf(3);
		return BigDecimal.valueOf(discont).multiply(ingredient.getPrice());
	}
	
}
