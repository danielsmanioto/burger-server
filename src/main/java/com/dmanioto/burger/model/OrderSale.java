package com.dmanioto.burger.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class OrderSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<OrderItem> itens;

    @ManyToMany
    private List<OrderDiscount> discounts;

    private BigDecimal totalPrice;

    public OrderSale(List<OrderItem> itens) {
        this.itens = itens;
    }

    public BigDecimal getTotalPriceItens() {
        return this.itens
                .stream()
                .map(e -> e.getPriceSale())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
