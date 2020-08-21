package com.dmanioto.burger.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dmanioto.burger.model.OrderItem;
import com.dmanioto.burger.model.OrderSale;
import com.dmanioto.burger.model.dto.OrderSaleDto;
import com.dmanioto.burger.service.OrderSaleService;

@RestController
@RequestMapping("/orders")
public class OrderSaleController {

	private OrderSaleService service;

	@Autowired
	public OrderSaleController(OrderSaleService service) {
		this.service = service;
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public OrderSale getById(@PathVariable("id") Long id) {
		return  service.findById(id);
	}

	@PostMapping
	public ResponseEntity<?> finishOrderSale(@RequestBody OrderSaleDto orderSale) {
		OrderSale orderResponse = service.finishOrder(orderSale);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(orderResponse.getId()).toUri();
		
		return ResponseEntity.created(uri).body(orderResponse);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<OrderSale> getAll() {
		return service.findAll();
	}
	
	@GetMapping("/itens")
	@ResponseStatus(HttpStatus.OK)
	public List<OrderItem> getItens() {
		return service.findAllItens();
	}
	
}
