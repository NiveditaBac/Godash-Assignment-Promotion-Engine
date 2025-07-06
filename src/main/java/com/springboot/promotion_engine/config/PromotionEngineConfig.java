package com.springboot.promotion_engine.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.promotion_engine.service.promotions.ComboPromotion;
import com.springboot.promotion_engine.service.promotions.FixedPricePromotion;
import com.springboot.promotion_engine.service.promotions.Promotion;
@Configuration
public class PromotionEngineConfig {
    
    @Bean
    public List<Promotion> promotions() {
        return List.of(
            new FixedPricePromotion('A', 3, 130),
            new FixedPricePromotion('B', 2, 45),
            new ComboPromotion('C', 'D', 30)
        );
    }
}
