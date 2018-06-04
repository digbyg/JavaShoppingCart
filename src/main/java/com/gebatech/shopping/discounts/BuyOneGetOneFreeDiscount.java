package com.gebatech.shopping.discounts;

import java.math.BigDecimal;

/**
 * 2 for the price of 1 implementation
 */
public class BuyOneGetOneFreeDiscount extends XForThePriceOfYDiscount {

    public static final DiscountStrategy INSTANCE = new BuyOneGetOneFreeDiscount();

    private BuyOneGetOneFreeDiscount() {}

    @Override
    protected BigDecimal getPriceMultiplier() {
        return BigDecimal.ONE;
    }

    @Override
    protected BigDecimal getUnitsInDeal() {
        return BigDecimal.valueOf(2);
    }
}
