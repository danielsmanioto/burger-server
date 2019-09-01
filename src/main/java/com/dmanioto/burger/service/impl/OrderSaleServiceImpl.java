package com.dmanioto.burger.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.dmanioto.burger.model.*;
import com.dmanioto.burger.model.builder.OrderItemBuilder;
import com.dmanioto.burger.model.builder.OrderSaleBuilder;
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
public class OrderSaleServiceImpl implements OrderSaleService {

    private final Logger LOG = LoggerFactory.getLogger(OrderSaleServiceImpl.class);

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

    public OrderSale finishOrder(OrderSaleDto dto) {
        List<OrderItem> itens = saveItensOrderSale(dto);

        OrderSale os = saveOrderSale(itens);

        updateTotalPrice(os.getId());

        LOG.info("Order save as success.");

        return repository.findById(os.getId()).get();
    }

    private void updateTotalPrice(Long orderId) {
        OrderSale os = getById(orderId);
        final BigDecimal totalPrice = promotionService.calculeTotalPrice(os);

        os.setTotalPrice(totalPrice);
        repository.save(os);
    }

    private OrderSale saveOrderSale(List<OrderItem> itens) {
        return repository.save(new OrderSaleBuilder()
                .setItens(itens)
                .createOrderSale());
    }

    private List<OrderItem> saveItensOrderSale(OrderSaleDto dto) {
        final Burger burger = burgerService.getById(dto.getBurger().getId());

        List<OrderItem> itens = new ArrayList<>();

        burger.getIngredients().forEach(ingredient -> {
            OrderItem item = new OrderItemBuilder().setIngredient(ingredient).setPrice(ingredient.getPrice()).createOrderItem();
            orderItemService.save(item);

            OrderItem orderItem = orderItemService.getOrderItem(item);
            itens.add(orderItem);
        });

        if (dto.getAditionals() != null) {

            dto.getAditionals().forEach(ingredient -> {
                Ingredient ingredientAditional = ingredientService.getById(ingredient.getId());
                OrderItem item = new OrderItemBuilder().setIngredient(ingredientAditional).setPrice(ingredientAditional.getPrice()).createOrderItem();
                orderItemService.save(item);

                OrderItem orderItem = orderItemService.getOrderItem(item);
                itens.add(orderItem);
            });

        }

        return itens;
    }

    @Override
    public List<OrderSale> getAll() {
        return repository.findAll();
    }

    @Override
    public List<OrderItem> getAllItens() {
        return orderItemService.getAll();
    }

    @Override
    public OrderSale getById(Long id) {
        return repository.findById(id).get();
    }

}
