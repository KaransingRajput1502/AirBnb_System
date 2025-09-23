package com.Self_Project.Air_Bnb_System.Strategy;

import com.Self_Project.Air_Bnb_System.entity.Inventory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


public interface PricingStrategy {

    BigDecimal calculatePrice(Inventory inventory);

}
