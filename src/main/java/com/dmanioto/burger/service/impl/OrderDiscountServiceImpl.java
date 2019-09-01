package com.dmanioto.burger.service.impl;

import java.math.BigDecimal;

import com.dmanioto.burger.model.builder.OrderDiscountBuilder;
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
        OrderDiscount discount = new OrderDiscountBuilder()
                .setDescription(description)
                .setValue(discountValue)
                .setOrderSale(orderSale)
                .createOrderDiscount();
        repository.save(discount);
    }

}
