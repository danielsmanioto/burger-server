package com.dmanioto.burger.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    private OrderSale orderSale;

    @ManyToOne
    private Ingredient ingredient;

    private BigDecimal priceSale;

    public OrderItem(Ingredient ingredient, BigDecimal price) {
        this.ingredient = ingredient;
        this.priceSale = price;
    }

}
