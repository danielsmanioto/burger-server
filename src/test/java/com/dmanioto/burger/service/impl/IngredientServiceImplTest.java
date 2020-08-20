package com.dmanioto.burger.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dmanioto.burger.model.Ingredient;
import com.dmanioto.burger.service.IngredientService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IngredientServiceImplTest {

	@Autowired
	private IngredientService service;

	@Test
	public void checkPriceOfLettuce() {
		final Ingredient lettuce = service.getLettuce();
		assertEquals(new BigDecimal("0.40"), lettuce.getPrice());
	}
	
	@Test
	public void checkPriceOfBacon() {
		final Ingredient bacon = service.getBacon();
		assertEquals(new BigDecimal("2.00"), bacon.getPrice());
	}
	
	@Test
	public void checkPriceOfMeatBacon() {
		final Ingredient meatBurger = service.getMeatBurger();
		assertEquals(new BigDecimal("3.00"), meatBurger.getPrice());
	}

	@Test
	public void checkPriceOfegg() {
		final Ingredient egg = service.getEgg();
		assertEquals(new BigDecimal("0.80"), egg.getPrice());
	}
	
	@Test
	public void checkPriceOfCheese() {
		final Ingredient cheese = service.getCheese();
		assertEquals(new BigDecimal("1.50"), cheese.getPrice());
	}

}
