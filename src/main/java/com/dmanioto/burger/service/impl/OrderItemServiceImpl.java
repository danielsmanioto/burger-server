package com.dmanioto.burger.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmanioto.burger.model.OrderItem;
import com.dmanioto.burger.repository.OrderItemRepository;
import com.dmanioto.burger.service.OrderItemService;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	@Autowired
	private OrderItemRepository repository;
	
	@Override
	public OrderItem getOrderItem(OrderItem item) {
		return repository.findById(item.getId()).get();
	}
	
	@Override
	public void save(OrderItem orderItem) {
		repository.save(orderItem);
	}

	@Override
	public List<OrderItem> getAll() {
		return repository.findAll();
	}
	
}
