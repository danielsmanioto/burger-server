package com.dmanioto.burger.model.dto;

import com.dmanioto.burger.model.Burger;
import com.dmanioto.burger.model.Ingredient;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderSaleDto {

    private Burger burger;
    private List<Ingredient> aditionals;

    public OrderSaleDto(Burger burger) {
        this.burger = burger;
    }

    public OrderSaleDto(Burger burger, List<Ingredient> aditionals) {
        this.burger = burger;
        this.aditionals = aditionals;
    }

}
