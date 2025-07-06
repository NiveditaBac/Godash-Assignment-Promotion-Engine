package com.springboot.promotion_engine.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartItem {
    private Sku sku;
    private int quantity;
}
