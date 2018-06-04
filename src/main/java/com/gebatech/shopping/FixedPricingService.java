package com.gebatech.shopping;

import com.gebatech.shopping.discounts.DiscountStrategy;
import com.gebatech.shopping.discounts.NoDiscount;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Simple implementation of a pricing service
 * Prices and discounts are loaded on startup and not changed for the duration or the app
 * More realistic implementations would allow updates over time but this is out of scope.
 */
public class FixedPricingService implements PricingService {

    private final Map<Item, BigDecimal> prices;
    private Map<Item, DiscountStrategy> discounts;

    public FixedPricingService(Map<Item, BigDecimal> prices, Map<Item, DiscountStrategy> discounts) {
        // This implementation doesn't allow these to change after startup, use copies to ensure this is the case
        this.prices = new HashMap<>(prices);
        this.discounts = new HashMap<>(discounts);
    }

    public BigDecimal calculatePrice(Map<Item, Integer> freqOfItems) {
        return freqOfItems.entrySet().stream().map(e -> {
            Item item = e.getKey();
            Integer quantity = e.getValue();

            DiscountStrategy discountStrategy = discounts.getOrDefault(item, NoDiscount.getInstance());

            BigDecimal unitPrice = prices.getOrDefault(item, BigDecimal.ZERO);

            return discountStrategy.applyStrategy(quantity, unitPrice);
        }).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
