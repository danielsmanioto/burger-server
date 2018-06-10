package com.dmanioto.burger.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmanioto.burger.model.Ingredient;
import com.dmanioto.burger.model.OrderItem;
import com.dmanioto.burger.model.OrderSale;
import com.dmanioto.burger.model.dto.OrderSaleDto;
import com.dmanioto.burger.repository.OrderItemRepository;
import com.dmanioto.burger.repository.OrderSaleRepository;
import com.dmanioto.burger.service.OrderSaleService;

@Service
public class OrderSaleServiceImpl implements OrderSaleService {

	private final Logger LOG = LoggerFactory.getLogger(OrderSaleServiceImpl.class);
	
	@Autowired
	private OrderSaleRepository repository;

	@Autowired
	private OrderItemRepository itemRepository;

	@Override
	public OrderSale finishOrder(OrderSaleDto dto) {
		List<OrderItem> itens = saveItensOrderSale(dto);

		OrderSale os = saveOrderSale(itens);
		
		LOG.info("Order save has success.");

		return repository.findById(os.getId()).get();
	}

	private OrderSale saveOrderSale(List<OrderItem> itens) {
		OrderSale os = new OrderSale(itens);
		repository.save(os);
		return os;
	}

	private List<OrderItem> saveItensOrderSale(OrderSaleDto dto) {
		List<OrderItem> itens = new ArrayList<>();
		for (Ingredient ingredient : dto.getBurger().getIngredients()) {
			OrderItem item = new OrderItem(ingredient.getId(), ingredient.getPrice());
			itemRepository.save(item);
			
			OrderItem orderItem = itemRepository.findById(item.getId()).get();
			itens.add(orderItem);
		}
		return itens;
	}

	@Override
	public List<OrderSale> getAll() {
		return repository.findAll();
	}

	@Override
	public List<OrderItem> getAllItens() {
		return itemRepository.findAll();
	}

}
