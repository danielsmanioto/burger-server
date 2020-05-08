package com.dmanioto.burger.service;

import java.util.List;

import com.dmanioto.burger.model.OrderItem;
import com.dmanioto.burger.model.OrderSale;
import com.dmanioto.burger.model.dto.OrderSaleDto;

public interface OrderSaleService {

	OrderSale finishOrder(OrderSaleDto dto);

	List<OrderSale> findAll();

	List<OrderItem> findAllItens();

	OrderSale findById(Long id);
	
}
