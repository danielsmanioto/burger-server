package com.dmanioto.burger.service.impl;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dmanioto.burger.model.Burger;
import com.dmanioto.burger.service.BurgerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BurgerServiceImplTest {
	
	@Autowired
	private BurgerService burgerService;
	
	@Test
	public void checkPriceBacon() {
		Burger xbacon = burgerService.getXBacon();
		assertEquals(BigDecimal.valueOf(6.5), xbacon.getPriceTotal());
	}
	
	@Test
	public void checkPriceBurger() {
		Burger xburger = burgerService.getXBurger();
		assertEquals(BigDecimal.valueOf(4.5), xburger.getPriceTotal());
	}

	@Test
	public void checkPricexEggBurger() {
		Burger xeggbacon = burgerService.getXEggBacon();
		assertEquals(BigDecimal.valueOf(7.3), xeggbacon.getPriceTotal());
	}
	
	@Test
	public void checkPricexEgg() {
		Burger xegg = burgerService.getXEgg();
		assertEquals(BigDecimal.valueOf(5.3), xegg.getPriceTotal());
	}
	
}
