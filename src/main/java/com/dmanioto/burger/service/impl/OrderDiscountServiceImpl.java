package com.dmanioto.burger.service.impl;

import com.dmanioto.burger.model.OrderDiscount;
import com.dmanioto.burger.repository.OrderDiscountRepository;
import com.dmanioto.burger.service.OrderDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDiscountServiceImpl implements OrderDiscountService {

    @Autowired
    private OrderDiscountRepository repository;

    @Override
    public void save(OrderDiscount orderDiscount) {
        repository.save(orderDiscount);
    }

}
