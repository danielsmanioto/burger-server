package com.dmanioto.burger.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmanioto.burger.model.OrderDiscount;
import com.dmanioto.burger.model.OrderSale;
import com.dmanioto.burger.repository.OrderDiscountRepository;
import com.dmanioto.burger.service.OrderDiscountService;

@Service
public class OrderDiscountServiceImpl implements OrderDiscountService {

	@Autowired
	private OrderDiscountRepository repository;
	
	@Override
	public void save(String description, BigDecimal discountValue, OrderSale orderSale) {
		OrderDiscount discount = new OrderDiscount(description, discountValue, orderSale);
		repository.save(discount);
	}

}
