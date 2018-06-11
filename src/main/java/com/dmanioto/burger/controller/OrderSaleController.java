package com.dmanioto.burger.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dmanioto.burger.model.OrderItem;
import com.dmanioto.burger.model.OrderSale;
import com.dmanioto.burger.model.dto.OrderSaleDto;
import com.dmanioto.burger.service.OrderSaleService;

@RestController
@RequestMapping("/orders")
public class OrderSaleController {
	
	@Autowired
	private OrderSaleService service;
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<OrderSale> getById(@PathVariable("id") Long id) {
		OrderSale orderSale = service.getById(id);
		
		return ResponseEntity.ok(orderSale);
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<?> finishOrderSale(@RequestBody OrderSaleDto orderSale) {
		OrderSale orderResponse = service.finishOrder(orderSale);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(orderResponse.getId()).toUri();
		
		return ResponseEntity.created(uri).body(orderResponse);
	}
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<OrderSale>> getAll() {
		
		final List<OrderSale> orders = service.getAll();

		return ResponseEntity.ok(orders);
	}
	
	@CrossOrigin
	@GetMapping("/itens")
	public ResponseEntity<List<OrderItem>> getItens() {
		final List<OrderItem> itens = service.getAllItens();

		return ResponseEntity.ok(itens);
	}
	
}
