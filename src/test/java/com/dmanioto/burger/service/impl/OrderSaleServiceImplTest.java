package com.dmanioto.burger.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
		final Burger xBacon = burgerService.getXBacon();
		final List<Ingredient> aditionals = new ArrayList<>(); 
		final OrderSaleDto dto = new OrderSaleDto(xBacon, aditionals);
		
		final OrderSale os = service.finishOrder(dto);

		assertNotNull(os);
		assertNotNull(os.getId());
		assertNotNull(os.getItens());
		
		assertEquals(3, os.getItens().size());
		assertEquals(BigDecimal.valueOf(6.5), os.getPriceTotal());
	}
	
	@Test
	public void checkSaleBasicWithXBurger() {
		final Burger xBurger = burgerService.getXBurger();
		final List<Ingredient> aditionals = new ArrayList<>();
		OrderSaleDto dto = new OrderSaleDto(xBurger, aditionals);
		
		final OrderSale os = service.finishOrder(dto);

		assertNotNull(os);
		assertNotNull(os.getId());
		assertNotNull(os.getItens());

		assertEquals(2, os.getItens().size());
		assertEquals(BigDecimal.valueOf(4.5), os.getPriceTotal());
	}
	
	@Test
	public void checkSaleBasicWithXEGG() {
		final Burger xEgg = burgerService.getXEgg();
		final List<Ingredient> aditionals = new ArrayList<>(); 
		final OrderSaleDto dto = new OrderSaleDto(xEgg, aditionals);
		
		final OrderSale os = service.finishOrder(dto);
		
		assertNotNull(os);
		assertNotNull(os.getId());
		assertNotNull(os.getItens());

		assertEquals(3, os.getItens().size());
		assertEquals(BigDecimal.valueOf(5.3), os.getPriceTotal());
	}
	
	@Test
	public void checkSaleBasicWithXggBacon() {
		final Burger xBurger = burgerService.getXEggBacon();
		final List<Ingredient> aditionals = new ArrayList<>(); 
		final OrderSaleDto dto = new OrderSaleDto(xBurger, aditionals);
		
		final OrderSale os = service.finishOrder(dto);

		assertNotNull(os);
		assertNotNull(os.getId());
		assertNotNull(os.getItens());

		assertEquals(4, os.getItens().size());
		assertEquals(BigDecimal.valueOf(7.3), os.getPriceTotal());
	}
	
}
