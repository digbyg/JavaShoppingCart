package com.gebatech.shopping.discounts;

import java.math.BigDecimal;

/**
 * Provides the discount calculation for x for the price of y type deals.
 * For example, "buy one get one free" is implemented as two for the price of one.
 */
public abstract class XForThePriceOfYDiscount implements DiscountStrategy {

    @Override
    public BigDecimal applyStrategy(BigDecimal quantity, BigDecimal unitPrice) {
        BigDecimal dealUnits = quantity.divide(getUnitsInDeal(), BigDecimal.ROUND_FLOOR);
        BigDecimal remainingUnits = quantity.remainder(getUnitsInDeal());

        BigDecimal dealPrice = unitPrice.multiply(getPriceMultiplier()).multiply(dealUnits);
        BigDecimal remainingUnitPrice = unitPrice.multiply(remainingUnits);
        return dealPrice.add(remainingUnitPrice);
    }

    protected abstract BigDecimal getPriceMultiplier();

    protected abstract BigDecimal getUnitsInDeal();
}
