package com.springboot.promotion_engine.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.springboot.promotion_engine.entity.CartItem;
import com.springboot.promotion_engine.entity.Sku;
import com.springboot.promotion_engine.service.promotions.ComboPromotion;
import com.springboot.promotion_engine.service.promotions.FixedPricePromotion;
import com.springboot.promotion_engine.service.promotions.Promotion;

public class CheckoutServiceTest {
    private CheckoutService checkoutService;

    @BeforeEach
    void setup() {
        List<Promotion> promotions = List.of(
                new FixedPricePromotion('A', 3, 130),
                new FixedPricePromotion('B', 2, 45),
                new ComboPromotion('C', 'D', 30)
        );
        checkoutService = new CheckoutService(promotions);
    }

    @Test 
    void testScenarioA() {

        List<CartItem> items = List.of(
                new CartItem(new Sku('A', 50), 1),
                new CartItem(new Sku('B', 30), 1),
                new CartItem(new Sku('C', 20), 1)
        );
        assertEquals(100, checkoutService.calculateTotal(items));
    }

    @Test
    void testScenarioB() {
        List<CartItem> items = List.of(
                new CartItem(new Sku('A', 50), 5),
                new CartItem(new Sku('B', 30), 5),
                new CartItem(new Sku('C', 20), 1)
        );
        assertEquals(370, checkoutService.calculateTotal(items));
    }

    @Test
    void testScenarioC() {
        List<CartItem> items = List.of(
                new CartItem(new Sku('A', 50), 3),
                new CartItem(new Sku('B', 30), 5),
                new CartItem(new Sku('C', 20), 1),
                new CartItem(new Sku('D', 15), 1)
        );
        assertEquals(280, checkoutService.calculateTotal(items));
    }
}