package com.gebatech.shopping;

import com.gebatech.shopping.discounts.BuyOneGetOneFreeDiscount;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 *
 */
public class BuyOneGetOneFreeDiscountTest {

    @Test
    public void appliesDiscountCorrectly() {
        // Discount not applied, unit price
        BigDecimal actualOne = BuyOneGetOneFreeDiscount.INSTANCE.applyStrategy(1, BigDecimal.TEN);
        Assert.assertEquals(BigDecimal.TEN, actualOne);

        // Discount applied once, unit price
        BigDecimal actualTwo = BuyOneGetOneFreeDiscount.INSTANCE.applyStrategy(2, BigDecimal.TEN);
        Assert.assertEquals(BigDecimal.TEN, actualTwo);

        // Discount applied twice with 1 item left over, (2 * unit price) + unit price
        BigDecimal actualFive = BuyOneGetOneFreeDiscount.INSTANCE.applyStrategy(5, BigDecimal.TEN);
        Assert.assertEquals(new BigDecimal(30), actualFive);

        // Discount applied 12 times with 2 items left over
        // (18 deals * unit price) + (1 remaining * unit price) ==  190
        BigDecimal actualThirtySeven = BuyOneGetOneFreeDiscount.INSTANCE.applyStrategy(38, BigDecimal.TEN);
        Assert.assertEquals(new BigDecimal(190), actualThirtySeven);
    }
}
