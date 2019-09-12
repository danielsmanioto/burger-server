package com.dmanioto.burger.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class IngredientControllerIT {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setup() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void findAllIgredients() throws Exception {
        final String json = "[{\"id\":1,\"description\":\"Alface\",\"price\":0.40},{\"id\":2,\"description\":\"Bacon\",\"price\":2.00},{\"id\":3,\"description\":\"Hamburguer de Carne\",\"price\":3.00},{\"id\":4,\"description\":\"Ovo\",\"price\":0.80},{\"id\":5,\"description\":\"Queijo\",\"price\":1.50}]";

        mvc.perform(get("/ingredients"))
                .andExpect(content().json(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF8"))
                .andExpect(jsonPath("$.[0].id").value("1"))
                .andExpect(jsonPath("$.[0].description").value("Alface"))
                .andExpect(jsonPath("$.[0].price").value("0.4"))
                .andExpect(jsonPath("$.[1].id").value("2"))
                .andExpect(jsonPath("$.[1].description").value("Bacon"))
                .andExpect(jsonPath("$.[1].price").value("2.0"));
    }

    @Test
    public void findIgredientsById() throws Exception {
        final String json = "{\"id\":1,\"description\":\"Alface\",\"price\":0.40}";

        mvc.perform(get("/ingredients/1"))
                .andExpect(content().json(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.description").value("Alface"));
    }
}
