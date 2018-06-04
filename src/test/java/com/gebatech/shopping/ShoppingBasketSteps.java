package com.gebatech.shopping;

import com.gebatech.shopping.discounts.BuyOneGetOneFreeDiscount;
import com.gebatech.shopping.discounts.DiscountStrategy;
import com.gebatech.shopping.discounts.ThreeForThePriceOfTwoDiscount;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static com.gebatech.shopping.Item.*;

/**
 *
 */
public class ShoppingBasketSteps {

    private Basket shoppingBasket;

    @Before
    public void setUp() {
        HashMap<Item, BigDecimal> prices = new HashMap<>();
        prices.put(Apple, new BigDecimal("0.35"));
        prices.put(Banana, new BigDecimal("0.20"));
        prices.put(Melon, new BigDecimal("0.50"));
        prices.put(Lime, new BigDecimal("0.15"));

        HashMap<Item, DiscountStrategy> discounts = new HashMap<>();
        discounts.put(Melon, BuyOneGetOneFreeDiscount.INSTANCE);
        discounts.put(Lime, ThreeForThePriceOfTwoDiscount.INSTANCE);

        PricingService pricingService = new FixedPricingService(prices, discounts);
        shoppingBasket = new InMemoryBasket(pricingService);
    }


    @Given("^a shopping basket with: ([A-Za-z,\\s]+)$")
    public void addItemsToBasket(String itemString) {
        String[] itemArray = itemString.replace(" ", "").split(",");
        List<Item> items = Arrays.stream(itemArray).map(Item::valueOf).collect(Collectors.toList());

        shoppingBasket.addItems(items);
    }

    @And("I then remove a ([A-Za-z]+)$")
    public void removeItemFromBasket(String item) {
        shoppingBasket.removeItem(Item.valueOf(item));
    }

    @When("^I calculate the total price with discounts$")
    public void calculatePrice() {
        shoppingBasket.calculatePrice();
    }

    @Then("^the price should be £([0-9.]+)$")
    public void showFinalPrice(String expected) {
        Assert.assertEquals(new BigDecimal(expected), shoppingBasket.calculatePrice());
    }

}
