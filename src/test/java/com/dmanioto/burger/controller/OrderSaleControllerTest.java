package com.dmanioto.burger.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dmanioto.burger.model.Burger;
import com.dmanioto.burger.model.Ingredient;
import com.dmanioto.burger.model.dto.OrderSaleDto;
import com.dmanioto.burger.service.BurgerService;
import com.dmanioto.burger.service.IngredientService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import({ EmbeddedMongoAutoConfiguration.class })
public class OrderSaleControllerTest {

	private static final String URL_POST_FINISH_SALE_ORDER = "/orders";

	private static final String CONTENT_TYPE = "application/json;charset=UTF8";

	private MockMvc mvc;

	private Gson gson = new GsonBuilder().create();
	
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private BurgerService burgerService;

	@Autowired
	private IngredientService ingService;
	
	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	public void finishOrderWithBurgerOfMenu() throws Exception {
		OrderSaleDto xBurgerDto = getXburgerDto();
		final String json = gson.toJson(xBurgerDto);
		
		mvc.perform(post(URL_POST_FINISH_SALE_ORDER)
				.contentType(CONTENT_TYPE)
				.content(json))
			.andExpect(status()
					.isCreated());

	}
	
	@Test
	public void finishOrderWithBurgerOfPromotionLigth() throws Exception {
		final OrderSaleDto order = getXburgerDto();
		final String json = gson.toJson(order);
		
		mvc.perform(post(URL_POST_FINISH_SALE_ORDER)
						.contentType(CONTENT_TYPE)
						.content(json))
					.andExpect(status()
							.isCreated());
	}
	
	// -------------
	private OrderSaleDto getXburgerDto() {
		final Burger xBurger = burgerService.getXBurger();
		OrderSaleDto xBurgerDto = new OrderSaleDto(xBurger);
		return xBurgerDto;
	}
	
	private OrderSaleDto getXbaconDto() {
		final Burger xBurger = burgerService.getXBacon();
		final List<Ingredient> itens = Arrays.asList(ingService.getLettuce());
		OrderSaleDto xBurgerDto = new OrderSaleDto(xBurger, itens);
		return xBurgerDto;
	}
	

}
