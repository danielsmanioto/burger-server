package com.dmanioto.burger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmanioto.burger.model.Burger;
import com.dmanioto.burger.service.BurgerService;

@RestController
@RequestMapping("/burgers")
public class BurgerController {
	
	@Autowired
	private BurgerService service;
	
	@GetMapping
	public ResponseEntity<List<Burger>> getAll() {

		List<Burger> burgers = service.getAll();

		return ResponseEntity.ok(burgers);
	}
	
}
