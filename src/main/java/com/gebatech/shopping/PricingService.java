package com.gebatech.shopping;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Calculates the value of items and respective quantities
 * Underlying implementation can deal with where to get prices, any discounts etc
 */
public interface PricingService {

    BigDecimal calculatePrice(Map<Item, Integer> freqOfItems);

}
