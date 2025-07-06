package com.springboot.promotion_engine.service.promotions;

import java.util.List;
import com.springboot.promotion_engine.entity.CartItem;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ComboPromotion implements Promotion{
    private char skuId1;
    private char skuId2;
    private int comboPrice;

    @Override
    public int apply(List<CartItem> items) {
        int total = 0;
        CartItem item1 = null;
        CartItem item2 = null;
        for(CartItem item : items){
            if(item.getSku().getId() == skuId1){
                item1 = item;
            }
            if(item.getSku().getId() == skuId2){
                item2 = item;
            }
        }
        if(item1 != null && item2 != null){
            int combo = Math.min(item1.getQuantity(), item2.getQuantity());
            total += combo * comboPrice;
            total += (item1.getQuantity() - combo) * item1.getSku().getUnitPrice();
            total += (item2.getQuantity() - combo) * item2.getSku().getUnitPrice();
        } else{
            if(item1 != null){
                total += item1.getQuantity() * item1.getSku().getUnitPrice();
            }
            if(item2 != null){
                total += item2.getQuantity() * item2.getSku().getUnitPrice();
            }
        }
        return total;
    }   
}