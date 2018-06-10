package com.dmanioto.burger.service;

import java.util.List;

import com.dmanioto.burger.model.OrderItem;
import com.dmanioto.burger.model.OrderSale;
import com.dmanioto.burger.model.dto.OrderSaleDto;

public interface OrderSaleService {

	OrderSale finishOrder(OrderSaleDto dto);

	List<OrderSale> getAll();

	List<OrderItem> getAllItens();

	OrderSale getById(Long id);
	
}
