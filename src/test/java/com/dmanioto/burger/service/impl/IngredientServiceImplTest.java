package com.dmanioto.burger.service.impl;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dmanioto.burger.model.Ingredient;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IngredientServiceImplTest {

	@Autowired
	private IngredientServiceImpl service;

	@Test
	public void checkPriceOfLettuce() {
		Ingredient lettuce = service.getLettuce();
		assertTrue(lettuce.getPrice().compareTo(BigDecimal.valueOf(0.4)) == 0);
	}
	
	@Test
	public void checkPriceOfBacon() {
		Ingredient bacon = service.getBacon();
		assertTrue(bacon.getPrice().compareTo(BigDecimal.valueOf(2.0)) == 0);		
	}
	
	@Test
	public void checkPriceOfMeatBacon() {
		Ingredient meatBurger = service.getMeatBurger();
		assertTrue(meatBurger.getPrice().compareTo(BigDecimal.valueOf(3.0)) == 0);		
	}

	@Test
	public void checkPriceOfegg() {
		Ingredient egg = service.getEgg();
		assertTrue(egg.getPrice().compareTo(BigDecimal.valueOf(0.8)) == 0);		
	}
	
	@Test
	public void checkPriceOfCheese() {
		Ingredient cheese = service.getCheese();
		assertTrue(cheese.getPrice().compareTo(BigDecimal.valueOf(1.5)) == 0);		
	}

}
