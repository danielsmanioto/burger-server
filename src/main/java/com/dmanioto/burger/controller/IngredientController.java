package com.dmanioto.burger.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dmanioto.burger.model.Ingredient;
import com.dmanioto.burger.service.IngredientService;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
	
	@Autowired
	private IngredientService service;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Ingredient> findAll() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Ingredient> findById(@PathVariable("id") Long id) {
		Optional<Ingredient> ingredient = Optional.ofNullable(service.getById(id));
		
		if (!ingredient.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(ingredient.get());
	}
	
}
