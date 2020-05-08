package com.dmanioto.burger.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dmanioto.burger.model.Burger;
import com.dmanioto.burger.service.BurgerService;

@RestController
@RequestMapping("/burgers")
public class BurgerController {

    @Autowired
    private BurgerService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Burger> findAll() {
        return service.findAll();
    }

	@GetMapping("/{id}")
    public ResponseEntity<Burger> findById(@PathVariable("id") Long id ) {
		Optional<Burger> burger = Optional.ofNullable(service.getById(id));

		if (!burger.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(burger.get());
	}

}
