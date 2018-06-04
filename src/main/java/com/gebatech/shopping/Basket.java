package com.gebatech.shopping;

import java.math.BigDecimal;
import java.util.List;

/**
 * How the user will interact with their shopping basket
 */
public interface Basket {

    void addItem(Item item);
    void addItems(List<Item> items);
    void removeItem(Item item);
    void emptyBasket();
    BigDecimal calculatePrice();
    int basketItemCount();
}
