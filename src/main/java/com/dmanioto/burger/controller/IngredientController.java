package com.dmanioto.burger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public ResponseEntity<List<Ingredient>> findAll() {
		
		List<Ingredient> ingredients = service.getAll();
		return ResponseEntity.ok(ingredients);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Ingredient> findById(@PathVariable("id") Long id) {

		final Ingredient ingredient = service.getById(id);
		return ResponseEntity.ok(ingredient);
	}
	
}
