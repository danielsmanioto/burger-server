package com.dmanioto.burger.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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
    private BurgerService service;

    @Test
    public void checkPriceBacon() {
        Burger xbacon = service.getXBacon().get();
        assertEquals(new BigDecimal("6.50"), xbacon.getPriceTotal());
    }

    @Test
    public void checkPriceBurger() {
        Burger xburger = service.getXBurger().get();
        assertEquals(new BigDecimal("4.50"), xburger.getPriceTotal());
    }

    @Test
    public void checkPricexEggBurger() {
        Burger xeggbacon = service.getXEggBacon().get();
        assertEquals(new BigDecimal("7.30"), xeggbacon.getPriceTotal());
    }

    @Test
    public void checkPricexEgg() {
        Burger xegg = service.getXEgg().get();
        assertEquals(new BigDecimal("5.30"), xegg.getPriceTotal());
    }

    @Test
    public void findAll() {
        List<Burger> burgers = service.findAll();
        assertNotNull(burgers);
    }

    @Test
    public void findById() {
        Optional<Burger> burger = service.getById(1L);
        assertNotNull(burger);
        assertNotNull(burger.get());
        assertEquals(1L, burger.get().getId(), 0.5);
        assertEquals("X-Bacon", burger.get().getDescription());
    }

}
