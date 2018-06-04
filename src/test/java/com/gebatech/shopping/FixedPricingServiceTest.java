package com.gebatech.shopping;

import com.gebatech.shopping.discounts.BuyOneGetOneFreeDiscount;
import com.gebatech.shopping.discounts.DiscountStrategy;
import com.gebatech.shopping.discounts.ThreeForThePriceOfTwoDiscount;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;

import static com.gebatech.shopping.Item.*;
import static org.junit.Assert.assertEquals;

/**
 *
 */
public class FixedPricingServiceTest {

    private HashMap<Item, BigDecimal> prices = new HashMap<>();

    @Before
    public void setUp() {
        prices.put(Apple, new BigDecimal("0.35"));
        prices.put(Banana, new BigDecimal("0.20"));
        prices.put(Melon, new BigDecimal("0.50"));
        prices.put(Lime, new BigDecimal("0.15"));
    }

    @Test
    public void pricingServiceWorksWithOutDiscounts() {

        HashMap<Item, DiscountStrategy> noDiscounts = new HashMap<>();
        PricingService fixedPricingService = new FixedPricingService(prices, noDiscounts);

        HashMap<Item, Integer> items = new HashMap<>();
        items.put(Apple, 5);
        items.put(Banana, 2);

        BigDecimal actualPrice = fixedPricingService.calculatePrice(items);
        assertEquals(new BigDecimal("2.15"), actualPrice);
    }

    @Test
    public void pricingServiceWorksWithDiscounts() {

        HashMap<Item, DiscountStrategy> discounts = new HashMap<>();
        discounts.put(Melon, BuyOneGetOneFreeDiscount.INSTANCE);
        discounts.put(Lime, ThreeForThePriceOfTwoDiscount.INSTANCE);

        PricingService fixedPricingService = new FixedPricingService(prices, discounts);

        HashMap<Item, Integer> items = new HashMap<>();
        items.put(Apple, 2); // (2 * 0.35) == 0.70
        items.put(Melon, 9); // (4 * 0.50) + 0.50 == 2.50
        items.put(Lime, 10); // (3 * 0.15 * 2) + 0.15 == 1.05

        BigDecimal actualPrice = fixedPricingService.calculatePrice(items);
        assertEquals(new BigDecimal("4.25"), actualPrice);
    }

}
