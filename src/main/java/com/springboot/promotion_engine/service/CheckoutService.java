package com.springboot.promotion_engine.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.promotion_engine.entity.CartItem;
import com.springboot.promotion_engine.service.promotions.Promotion;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CheckoutService {
    
    private final List<Promotion> promotions;

    public int calculateTotal(List<CartItem> cartItems){
        int total = 0;
        List<CartItem> items = new ArrayList<>(cartItems);
        for(Promotion promo : promotions){
            total += promo.apply(items);
        }
        return total;
    }
}
