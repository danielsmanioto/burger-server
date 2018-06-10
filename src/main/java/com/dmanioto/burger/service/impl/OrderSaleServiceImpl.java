package com.dmanioto.burger.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmanioto.burger.model.Burger;
import com.dmanioto.burger.model.Ingredient;
import com.dmanioto.burger.model.OrderItem;
import com.dmanioto.burger.model.OrderSale;
import com.dmanioto.burger.model.dto.OrderSaleDto;
import com.dmanioto.burger.repository.OrderItemRepository;
import com.dmanioto.burger.repository.OrderSaleRepository;
import com.dmanioto.burger.service.OrderSaleService;

@Service
public class OrderSaleServiceImpl implements OrderSaleService {

	@Autowired
	private OrderSaleRepository repository;

	@Autowired
	private OrderItemRepository itemRepository;

	@Override
	public OrderSale finishOrder(OrderSaleDto dto) {
		// salvar itens
		List<OrderItem> itens = new ArrayList<>();
		for (Ingredient ingredient : dto.getBurger().getIngredients()) {
			OrderItem item = new OrderItem(ingredient.getId(), ingredient.getPrice());
			itemRepository.save(item);
			
			OrderItem orderItem = itemRepository.findById(item.getId()).get();
			itens.add(orderItem);
		}

		// salvar pedido
		OrderSale os = new OrderSale(itens);
		repository.save(os);

		return repository.findById(os.getId()).get();
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
