package com.springboot.promotion_engine.service.promotions;

import java.util.List;
import com.springboot.promotion_engine.entity.CartItem;

public interface Promotion {
    int apply(List<CartItem> items);
}
