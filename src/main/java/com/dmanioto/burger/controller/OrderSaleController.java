package com.dmanioto.burger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmanioto.burger.model.OrderItem;
import com.dmanioto.burger.model.OrderSale;
import com.dmanioto.burger.model.dto.OrderSaleDto;
import com.dmanioto.burger.service.OrderSaleService;

@RestController
@RequestMapping("/orders")
public class OrderSaleController {
	
	@Autowired
	private OrderSaleService service;
	
	@PostMapping
	public ResponseEntity<Void> finishOrderSale(@RequestBody OrderSaleDto orderSale) {
		
		service.finishOrder(orderSale);
		
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<OrderSale>> getAll() {
		
		final List<OrderSale> orders = service.getAll();

		return ResponseEntity.ok(orders);
	}
	
	@GetMapping("/itens")
	public ResponseEntity<List<OrderItem>> getItens() {
		
		final List<OrderItem> itens = service.getAllItens();

		return ResponseEntity.ok(itens);
	}
	
}
