package com.dmanioto.burger.service;

import java.util.List;

import com.dmanioto.burger.model.OrderItem;

public interface OrderItemService {

	OrderItem getOrderItem(OrderItem item);

	void save(OrderItem orderItem);

	List<OrderItem> getAll();

}
