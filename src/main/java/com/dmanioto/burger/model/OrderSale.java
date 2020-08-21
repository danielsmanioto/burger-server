package com.dmanioto.burger.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<OrderItem> itens;

    @ManyToMany
    private List<OrderDiscount> discounts;

    private BigDecimal totalPrice;

    public BigDecimal getTotalPriceItens() {
        return this.itens
                .stream()
                .map(e -> e.getPriceSale())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
