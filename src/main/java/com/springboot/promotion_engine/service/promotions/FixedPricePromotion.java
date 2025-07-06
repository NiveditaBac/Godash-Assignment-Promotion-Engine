package com.springboot.promotion_engine.service.promotions;

import java.util.List;
import com.springboot.promotion_engine.entity.CartItem;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FixedPricePromotion implements Promotion{
    private char skuId;
    private int quantityRequired;
    private int promoPrice;
    
    @Override
    public int apply(List<CartItem> items) {
        int total = 0;
        for(CartItem item : items){
            if(item.getSku().getId() == skuId){
                int quantity = item.getQuantity();
                total += (quantity / quantityRequired) * promoPrice;
                total += (quantity % quantityRequired) * item.getSku().getUnitPrice();
            }
        }
        return total;
    }
}