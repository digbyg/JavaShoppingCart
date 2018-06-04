package com.gebatech.shopping.discounts;

import java.math.BigDecimal;

/**
 * Default implementation, no discount so return quantity times unit price
 */
public class NoDiscount implements DiscountStrategy {

    private static final DiscountStrategy INSTANCE = new NoDiscount();

    private NoDiscount() {}

    public static DiscountStrategy getInstance() {
        return INSTANCE;
    }

    @Override
    public BigDecimal applyStrategy(BigDecimal quantity, BigDecimal unitPrice) {
        return unitPrice.multiply(quantity);
    }
}
