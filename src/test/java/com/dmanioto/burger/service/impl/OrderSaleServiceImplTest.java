package com.dmanioto.burger.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dmanioto.burger.model.Burger;
import com.dmanioto.burger.model.Ingredient;
import com.dmanioto.burger.model.OrderSale;
import com.dmanioto.burger.model.dto.OrderSaleDto;
import com.dmanioto.burger.service.BurgerService;
import com.dmanioto.burger.service.OrderSaleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderSaleServiceImplTest {
	
	@Autowired
	private OrderSaleService service;
	
	@Autowired
	private BurgerService burgerService;
	
	@Test
	public void checkSaleBasicWithXBacon() {
		final Optional<Burger> xBacon = burgerService.getXBacon();
		final List<Ingredient> aditionals = new ArrayList<>(); 
		final OrderSaleDto dto = new OrderSaleDto(xBacon.get(), aditionals);
		
		final OrderSale os = service.finishOrder(dto);

		assertNotNull(os);
		assertNotNull(os.getId());
		assertNotNull(os.getItens());
		
		assertEquals(3, os.getItens().size());
		assertEquals(new BigDecimal("6.50"), os.getTotalPrice());
	}
	
	@Test
	public void checkSaleBasicWithXBurger() {
		final Optional<Burger> xBurger = burgerService.getXBurger();
		final List<Ingredient> aditionals = new ArrayList<>();
		OrderSaleDto dto = new OrderSaleDto(xBurger.get(), aditionals);
		
		final OrderSale os = service.finishOrder(dto);

		assertNotNull(os);
		assertNotNull(os.getId());
		assertNotNull(os.getItens());

		assertEquals(2, os.getItens().size());
		assertEquals(new BigDecimal("4.50"), os.getTotalPrice());
	}
	
	@Test
	public void checkSaleBasicWithXEGG() {
		final Optional<Burger> xEgg = burgerService.getXEgg();
		final List<Ingredient> aditionals = new ArrayList<>(); 
		final OrderSaleDto dto = new OrderSaleDto(xEgg.get(), aditionals);
		
		final OrderSale os = service.finishOrder(dto);
		
		assertNotNull(os);
		assertNotNull(os.getId());
		assertNotNull(os.getItens());

		assertEquals(3, os.getItens().size());
		assertEquals(new BigDecimal("5.30"), os.getTotalPrice());
	}
	
	@Test
	public void checkSaleBasicWithXggBacon() {
		final Optional<Burger> xEggBacon = burgerService.getXEggBacon();
		final List<Ingredient> aditionals = new ArrayList<>(); 
		final OrderSaleDto dto = new OrderSaleDto(xEggBacon.get(), aditionals);
		
		final OrderSale os = service.finishOrder(dto);

		assertNotNull(os);
		assertNotNull(os.getId());
		assertNotNull(os.getItens());

		assertEquals(4, os.getItens().size());
		assertEquals(new BigDecimal("7.30"), os.getTotalPrice());
	}
	
}
