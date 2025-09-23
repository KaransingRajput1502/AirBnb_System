package com.Self_Project.Air_Bnb_System.Strategy;

import com.Self_Project.Air_Bnb_System.entity.Inventory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@RequiredArgsConstructor
public class SurgePricingStrategy implements PricingStrategy{

    private final PricingStrategy wrapped;

    @Override
    public BigDecimal calculatePrice(Inventory inventory) {
        //return wrapped.calculatePrice(inventory).multiply(inventory.getSurgeFactor());
        //calculate wrapped price ex.100 and then multiply price as per need 1.2x etc.
        BigDecimal price = wrapped.calculatePrice(inventory);
        return price.multiply(inventory.getSurgeFactor());

    }
}
