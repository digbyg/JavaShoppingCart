package com.gebatech.shopping.discounts;

import java.math.BigDecimal;

/**
 * Main interface for any discount logic
 */
public interface DiscountStrategy {

    /**
     * Helper method purely to reduce the boiler plate code of creating a big decimal from an integer
     * @see DiscountStrategy#applyStrategy(BigDecimal, BigDecimal)
     */
    default BigDecimal applyStrategy(int quantity, BigDecimal unitPrice) {
        return applyStrategy(BigDecimal.valueOf(quantity), unitPrice);
    }

    /**
     * Given an item quantity and unit price, the underling implementation can calculate the total cost
     * @return the total price for these items taking into account the quantity based discount logic
     */
    BigDecimal applyStrategy(BigDecimal quantity, BigDecimal unitPrice);

}
