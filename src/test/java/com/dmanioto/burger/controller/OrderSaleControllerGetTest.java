package com.dmanioto.burger.controller;

import com.dmanioto.burger.model.Burger;
import com.dmanioto.burger.model.dto.OrderSaleDto;
import com.dmanioto.burger.service.BurgerService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class OrderSaleControllerGetTest {

    private static final String URL_ORDERS = "/orders";
    private static final String CONTENT_TYPE = "application/json;charset=UTF8";

    private MockMvc mvc;
    private Gson gson = new GsonBuilder().create();

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private BurgerService burgerService;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void getAllOrdersReturnsOk() throws Exception {
        mvc.perform(get(URL_ORDERS))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllOrderItensReturnsOk() throws Exception {
        mvc.perform(get(URL_ORDERS + "/itens"))
                .andExpect(status().isOk());
    }

    @Test
    public void getOrderByIdAfterCreation() throws Exception {
        final Optional<Burger> xBurger = burgerService.getXBurger();
        final OrderSaleDto orderDto = new OrderSaleDto(xBurger.get(), new ArrayList<>());
        final String json = gson.toJson(orderDto);

        MvcResult result = mvc.perform(post(URL_ORDERS).contentType(CONTENT_TYPE).content(json))
                .andExpect(status().isCreated())
                .andReturn();

        String location = result.getResponse().getHeader("Location");
        String id = location.substring(location.lastIndexOf('/') + 1);

        mvc.perform(get(URL_ORDERS + "/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.totalPrice").value(4.5));
    }

}
