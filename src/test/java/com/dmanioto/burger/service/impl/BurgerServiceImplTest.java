package com.dmanioto.burger.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.List;

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
    private BurgerService burgerServiceImpl;

    @Test
    public void checkPriceBacon() {
        Burger xbacon = burgerServiceImpl.getXBacon();
        assertEquals(new BigDecimal("6.50"), xbacon.getPriceTotal());
    }

    @Test
    public void checkPriceBurger() {
        Burger xburger = burgerServiceImpl.getXBurger();
        assertEquals(new BigDecimal("4.50"), xburger.getPriceTotal());
    }

    @Test
    public void checkPricexEggBurger() {
        Burger xeggbacon = burgerServiceImpl.getXEggBacon();
        assertEquals(new BigDecimal("7.30"), xeggbacon.getPriceTotal());
    }

    @Test
    public void checkPricexEgg() {
        Burger xegg = burgerServiceImpl.getXEgg();
        assertEquals(new BigDecimal("5.30"), xegg.getPriceTotal());
    }

    @Test
    public void findAll() {
        List<Burger> burgers = burgerServiceImpl.findAll();
        assertNotNull(burgers);
    }

    @Test
    public void findById() {
        Burger burger = burgerServiceImpl.getById(1L);
        assertNotNull(burger);
        assertEquals(1L, burger.getId(), 0.5);
        assertEquals("X-Bacon", burger.getDescription());
    }

}
