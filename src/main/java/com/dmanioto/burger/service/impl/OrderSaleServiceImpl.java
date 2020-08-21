package com.dmanioto.burger.service.impl;

import com.dmanioto.burger.model.Burger;
import com.dmanioto.burger.model.Ingredient;
import com.dmanioto.burger.model.OrderItem;
import com.dmanioto.burger.model.OrderSale;
import com.dmanioto.burger.model.dto.OrderSaleDto;
import com.dmanioto.burger.repository.OrderSaleRepository;
import com.dmanioto.burger.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        return repository.save(OrderSale
                .builder()
                .itens(itens)
                .build());
    }

    private List<OrderItem> saveItensOrderSale(OrderSaleDto dto) {
        final Optional<Burger> burger = burgerService.getById(dto.getBurger().getId());

        List<OrderItem> itens = new ArrayList<>();
        saveIngredients(burger.get(), itens);
        saveAditionals(dto, itens);

        return itens;
    }

    private void saveIngredients(Burger burger, List<OrderItem> itens) {
        burger.getIngredients()
                .stream()
                .forEach(ingredient -> {
                    OrderItem item = OrderItem.builder()
                            .ingredient(ingredient)
                            .priceSale(ingredient.getPrice())
                            .build();
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
                        OrderItem item = OrderItem.builder()
                                .ingredient(ingredientAditional)
                                .priceSale(ingredient.getPrice())
                                .build();
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
