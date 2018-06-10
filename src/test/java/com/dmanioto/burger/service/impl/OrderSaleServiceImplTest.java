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
	public void checkPromotionBasicWithBurger() {
		final Burger xBurger = burgerService.getXBurger();
		final List<Ingredient> aditionals = new ArrayList<>(); //Arrays.asList(ingService.getLettuce());
		OrderSaleDto dto = new OrderSaleDto(xBurger, aditionals);
		
		final OrderSale os = service.finishOrder(dto);
		
		assertEquals(1L, os.getId(), 0.5);
		assertNotNull(os);
		assertNotNull(os.getItens());
		assertEquals(2, os.getItens().size());
		assertEquals(BigDecimal.valueOf(4.5), os.getPriceTotal());
	}
	
}
