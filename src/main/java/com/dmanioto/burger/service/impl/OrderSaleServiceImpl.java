package com.dmanioto.burger.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.dmanioto.burger.model.*;
import com.dmanioto.burger.model.builder.OrderItemBuilder;
import com.dmanioto.burger.model.builder.OrderSaleBuilder;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmanioto.burger.model.dto.OrderSaleDto;
import com.dmanioto.burger.repository.OrderSaleRepository;
import com.dmanioto.burger.service.BurgerService;
import com.dmanioto.burger.service.IngredientService;
import com.dmanioto.burger.service.OrderItemService;
import com.dmanioto.burger.service.OrderSaleService;
import com.dmanioto.burger.service.PromotionDiscount;

@Service
@Slf4j
public class OrderSaleServiceImpl implements OrderSaleService {

    @Autowired
    private OrderSaleRepository repository;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private PromotionDiscount promotionService;

    @Autowired
    private BurgerService burgerService;

    @Autowired
    private IngredientService ingredientService;

    @Override
    public OrderSale finishOrder(OrderSaleDto dto) {
        List<OrderItem> itens = saveItensOrderSale(dto);

        OrderSale os = saveOrderSale(itens);

        updateTotalPrice(os.getId());

        log.info("Order save as success.");

        return repository.findById(os.getId()).get();
    }

    private void updateTotalPrice(Long orderId) {
        OrderSale os = findById(orderId);
        final BigDecimal totalPrice = promotionService.calculeTotalPrice(os);
        os.setTotalPrice(totalPrice);
        repository.save(os);
    }

    private OrderSale saveOrderSale(List<OrderItem> itens) {
        return repository.save(new OrderSaleBuilder()
                .withItens(itens)
                .createOrderSale());
    }

    private List<OrderItem> saveItensOrderSale(OrderSaleDto dto) {
        final Burger burger = burgerService.getById(dto.getBurger().getId());

        List<OrderItem> itens = new ArrayList<>();
        saveIngredients(burger, itens);
        saveAditionals(dto, itens);

        return itens;
    }

    private void saveIngredients(Burger burger, List<OrderItem> itens) {
        burger.getIngredients()
                .stream()
                .forEach(ingredient -> {
                    OrderItem item = new OrderItemBuilder().
                            withIngredient(ingredient).
                            withPrice(ingredient.getPrice()).
                            createOrderItem();
                    orderItemService.save(item);
                    itens.add(orderItemService.getOrderItem(item));
                });
    }

    private void saveAditionals(OrderSaleDto dto, List<OrderItem> itens) {
        if (dto.getAditionals() != null) {

            dto.getAditionals()
                    .stream()
                    .forEach(ingredient -> {
                        Ingredient ingredientAditional = ingredientService.getById(ingredient.getId());
                        OrderItem item = new OrderItemBuilder().
                                withIngredient(ingredientAditional)
                                .withPrice(ingredientAditional.getPrice())
                                .createOrderItem();
                        orderItemService.save(item);

                        OrderItem orderItem = orderItemService.getOrderItem(item);
                        itens.add(orderItem);
                    });
        }
    }

    @Override
    public List<OrderSale> findAll() {
        return repository.findAll();
    }

    @Override
    public List<OrderItem> findAllItens() {
        return orderItemService.getAll();
    }

    @Override
    public OrderSale findById(Long id) {
        return repository.findById(id).get();
    }

}
