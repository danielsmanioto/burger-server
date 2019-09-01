package com.dmanioto.burger.model.builder;

import com.dmanioto.burger.model.OrderItem;
import com.dmanioto.burger.model.OrderSale;

import java.util.List;

public class OrderSaleBuilder {
    private List<OrderItem> itens;

    public OrderSaleBuilder setItens(List<OrderItem> itens) {
        this.itens = itens;
        return this;
    }

    public OrderSale createOrderSale() {
        return new OrderSale(itens);
    }
}