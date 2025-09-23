package com.Self_Project.Air_Bnb_System.Strategy;

import com.Self_Project.Air_Bnb_System.entity.Inventory;

import java.math.BigDecimal;

public class BasePricingStrategy implements PricingStrategy{

    @Override
    public BigDecimal calculatePrice(Inventory inventory) {
        return inventory.getRoom().getBasePrice();
    }
}
