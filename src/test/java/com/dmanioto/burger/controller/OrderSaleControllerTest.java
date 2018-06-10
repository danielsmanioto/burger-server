package com.dmanioto.burger.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
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
import com.dmanioto.burger.model.OrderSale;
import com.dmanioto.burger.model.dto.OrderSaleDto;
import com.dmanioto.burger.service.BurgerService;
import com.dmanioto.burger.service.IngredientService;
import com.dmanioto.burger.service.OrderSaleService;
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
	private OrderSaleService service;

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
		final Burger xBurger = burgerService.getXBurger();
		final List<Ingredient> aditionals = new ArrayList<>();
		final OrderSaleDto orderDto = new OrderSaleDto(xBurger, aditionals);
		final String json = gson.toJson(orderDto);
		
		mvc.perform(post(URL_POST_FINISH_SALE_ORDER).contentType(CONTENT_TYPE).content(json))
				.andExpect(status().isCreated())
				.andExpect(jsonPath("$.priceTotal", equalTo(4.05)));
	}

	@Test
	public void finishOrderWithBurgerOfPromotionLigth() throws Exception {
		final Burger xBurgerLigth = burgerService.getXBurger();
		final List<Ingredient> aditionals = Arrays.asList(ingService.getLettuce());
		final OrderSaleDto orderDto = new OrderSaleDto(xBurgerLigth, aditionals);

		final String json = gson.toJson(orderDto);

		mvc.perform(post(URL_POST_FINISH_SALE_ORDER).contentType(CONTENT_TYPE).content(json))
				.andExpect(status().isCreated());

		OrderSale os = service.getById(2L); // TODO mudar id

		assertNotNull(os);
		assertNotNull(os.getId());
		assertNotNull(os.getItens());

		assertEquals(3, os.getItens().size());
		assertEquals(BigDecimal.valueOf(4.9), os.getPriceTotal());
	}

	@Test
	public void checkSaleAlotOfMeat() throws Exception {
		final Burger xBurgerLigth = burgerService.getXBurger();
		final List<Ingredient> aditionals = Arrays.asList(ingService.getLettuce());
		final OrderSaleDto orderDto = new OrderSaleDto(xBurgerLigth, aditionals);

		final String json = gson.toJson(orderDto);

		mvc.perform(post(URL_POST_FINISH_SALE_ORDER).contentType(CONTENT_TYPE).content(json))
				.andExpect(status().isCreated());

		OrderSale os = service.getById(2L); // TODO mudar id

		assertNotNull(os);
		assertNotNull(os.getId());
		assertNotNull(os.getItens());

		assertEquals(4, os.getItens().size());
		assertEquals(BigDecimal.valueOf(4.9), os.getPriceTotal());
	}

}
