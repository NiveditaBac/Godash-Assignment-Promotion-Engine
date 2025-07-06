package com.springboot.promotion_engine.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.promotion_engine.entity.CartItem;
import com.springboot.promotion_engine.service.CheckoutService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(CheckoutController.CHECKOUT_API_ENDPOINT)
@RequiredArgsConstructor
public class CheckoutController {
     public static final String CHECKOUT_API_ENDPOINT = "/api/checkout";
    
    private final CheckoutService checkoutService;

    @PostMapping
    public ResponseEntity<Integer> calculateTotal(@RequestBody List<CartItem> items) {
        return ResponseEntity.ok(checkoutService.calculateTotal(items));
    }
}
