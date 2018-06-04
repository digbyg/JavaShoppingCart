Feature: calculate price for example shopping baskets

  Scenario: calculate price including the discounts
    Given a shopping basket with: Apple, Apple, Banana, Melon, Lime, Melon, Lime, Melon, Lime, Melon, Lime
        And I then remove a Melon
    When I calculate the total price with discounts
        Then the price should be £2.35

  Scenario: calculate price when there are no discounts
    Given a shopping basket with: Apple, Apple, Banana, Melon, Lime, Lime, Lime
        And I then remove a Lime
    When I calculate the total price with discounts
        Then the price should be £1.70
