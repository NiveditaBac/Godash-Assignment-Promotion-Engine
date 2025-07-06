package com.springboot.promotion_engine.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Sku {
    private char id;
    private int unitPrice;
}
