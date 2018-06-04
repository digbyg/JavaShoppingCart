package com.gebatech.shopping;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static com.gebatech.shopping.Item.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by Grant on 23/05/2018.
 *
 * Asumptions
 *  Prices are integers
 *  Total price will be less than Integer.MAX_INT
 */

public class InMemoryBasketTest {

    private PricingService mockPricingService = mock(PricingService.class);
    private Basket basket = new InMemoryBasket(mockPricingService);

    @Before
    public void setUp() {
        basket.emptyBasket();
    }

    @Test
    public void clearsBasket() {
        basket.addItem(Banana);

        assertEquals(basket.basketItemCount(), 1);

        basket.emptyBasket();

        assertEquals(basket.basketItemCount(), 0);
    }

    @Test
    public void addAndRemoveItems() {
        basket.addItem(Banana);
        ArrayList<Item> firstItemList = new ArrayList<>();
        firstItemList.add(Banana);
        firstItemList.add(Banana);
        firstItemList.add(Apple);
        basket.addItems(firstItemList);

        ArrayList<Item> secondItemList = new ArrayList<>();
        secondItemList.add(Banana);
        secondItemList.add(Banana);
        secondItemList.add(Apple);
        secondItemList.add(Melon);
        basket.addItems(secondItemList);

        assertEquals(basket.basketItemCount(), 8);

        basket.removeItem(Banana);
        assertEquals(basket.basketItemCount(), 7);
        basket.removeItem(Apple);
        assertEquals(basket.basketItemCount(), 6);
    }


    @Test
    public void removeItemsNotInBasket() {
        assertEquals(basket.basketItemCount(), 0);
        basket.removeItem(Apple);

        assertEquals(basket.basketItemCount(), 0);
    }
}
