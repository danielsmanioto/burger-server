package com.dmanioto.burger.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dmanioto.burger.model.Burger;
import com.dmanioto.burger.service.BurgerService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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

	@GetMapping("/{id}")
    public ResponseEntity<Burger> findById(@PathVariable("id") Long id ) {
		Optional<Burger> burger = Optional.ofNullable(service.getById(id));

		if (burger.isPresent()) {
			return ResponseEntity.ok(burger.get());
		} else {
			return  ResponseEntity.notFound().build();
		}

	}

}
