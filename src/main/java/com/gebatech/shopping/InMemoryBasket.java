package com.gebatech.shopping;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Simple in-memory implementation of the shopping basket
 * There would be one of these per user, but it's thread safe for that user so they can send in concurrent updates
 */
public class InMemoryBasket implements Basket {

    private final Map<Item, Integer> basketContents = new ConcurrentHashMap<>();
    private final PricingService pricingService;

    public InMemoryBasket(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    @Override
    public void addItem(Item item) {
        basketContents.compute(item, (key, count) -> count == null ? 1 : count + 1);
    }

    @Override
    public void addItems(List<Item> items) {
        items.forEach(this::addItem);
    }

    @Override
    public void removeItem(Item item) {
        basketContents.computeIfPresent(item, (key, count) -> count <= 1 ? null : count -1);
    }

    @Override
    public void emptyBasket() {
        basketContents.clear();
    }

    @Override
    public BigDecimal calculatePrice() {
        return pricingService.calculatePrice(basketContents);
    }

    @Override
    public int basketItemCount() {
        return basketContents.values().stream().mapToInt(Number::intValue).sum();
    }
}
