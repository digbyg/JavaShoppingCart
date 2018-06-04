package com.gebatech.shopping;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {
                "html:target/cucumber/shoppingbasket.html",
                "pretty"
        }
)
public class ShoppingBasketTest {
}
