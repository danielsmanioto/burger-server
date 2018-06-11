package com.dmanioto.burger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmanioto.burger.model.Ingredient;
import com.dmanioto.burger.service.IngredientService;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
	
	@Autowired
	private IngredientService service;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Ingredient>> getAll() {
		
		List<Ingredient> ingredients = service.getAll();

		return ResponseEntity.ok(ingredients);
	}
	
}
