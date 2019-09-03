package com.dmanioto.burger.service.impl;

import com.dmanioto.burger.model.OrderSale;
import com.dmanioto.burger.service.PromotionDiscount;
import com.dmanioto.burger.service.impl.discount.DiscountALotOfCheeseDiscountImpl;
import com.dmanioto.burger.service.impl.discount.DiscountALotOfMeatDiscountImpl;
import com.dmanioto.burger.service.impl.discount.DiscountLigthDiscountImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PromotionDiscountImpl implements PromotionDiscount {

	@Autowired
	private DiscountLigthDiscountImpl discountLigthDiscount;

	@Autowired
	private DiscountALotOfMeatDiscountImpl discountALotOfMeatDiscount;

	@Autowired
	private DiscountALotOfCheeseDiscountImpl discountALotOfCheeseDiscount;
	
	@Override
	public BigDecimal calculeTotalPrice(OrderSale orderSale) {
		final BigDecimal totalPrice = orderSale.getTotalPriceItens();

		final BigDecimal totalDiscount = calculateDiscount(orderSale);

		return totalPrice.subtract(totalDiscount);
	}
	
	private BigDecimal calculateDiscount(OrderSale os) {
		BigDecimal discountLigth = discountLigthDiscount.calculate(os);
		BigDecimal discountMeet = discountALotOfMeatDiscount.calculate(os);
	  	BigDecimal discountCheese = discountALotOfCheeseDiscount.calculate(os);

		return discountLigth
				.add(discountMeet)
				.add(discountCheese);
	}

}
