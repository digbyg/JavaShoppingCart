package com.gebatech.shopping.discounts;

import java.math.BigDecimal;

/**
 * 3 for the price of 2 implementation
 */
public class ThreeForThePriceOfTwoDiscount extends XForThePriceOfYDiscount {

    public static final DiscountStrategy INSTANCE = new ThreeForThePriceOfTwoDiscount();

    private BigDecimal priceMultiplier = new BigDecimal(2);
    private BigDecimal unitsInDeal = new BigDecimal(3);

    private ThreeForThePriceOfTwoDiscount() {}

    @Override
    protected BigDecimal getPriceMultiplier() {
        return priceMultiplier;
    }

    @Override
    protected BigDecimal getUnitsInDeal() {
        return unitsInDeal;
    }
}
