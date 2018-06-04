package com.gebatech.shopping;

import com.gebatech.shopping.discounts.ThreeForThePriceOfTwoDiscount;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 *
 */
public class ThreeForThePriceOfTwoDiscountTest {

    @Test
    public void appliesDiscountCorrectly() {
        // Discount not applied, unit price
        BigDecimal actualOne = ThreeForThePriceOfTwoDiscount.INSTANCE.applyStrategy(1, BigDecimal.TEN);
        Assert.assertEquals(BigDecimal.TEN, actualOne);

        // Discount not applied, 2 * unit price
        BigDecimal actualTwo = ThreeForThePriceOfTwoDiscount.INSTANCE.applyStrategy(2, BigDecimal.TEN);
        Assert.assertEquals(new BigDecimal(20), actualTwo);

        // Discount applied once, 2 * unit price
        BigDecimal actualThree = ThreeForThePriceOfTwoDiscount.INSTANCE.applyStrategy(3, BigDecimal.TEN);
        Assert.assertEquals(new BigDecimal(20), actualThree);

        // Discount applied once with 1 item left over, (2 * unit price) + unit price
        BigDecimal actualFour = ThreeForThePriceOfTwoDiscount.INSTANCE.applyStrategy(4, BigDecimal.TEN);
        Assert.assertEquals(new BigDecimal(30), actualFour);

        // Discount applied 12 times with 2 items left over
        // (12 deals * unit price * 2) + (2 remaining * unit price) ==  260
        BigDecimal actualThirtyEight = ThreeForThePriceOfTwoDiscount.INSTANCE.applyStrategy(38, BigDecimal.TEN);
        Assert.assertEquals(new BigDecimal(260), actualThirtyEight);
    }
}
