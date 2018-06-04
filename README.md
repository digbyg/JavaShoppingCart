# Shopping Basket implementation

I used Maven 3.3.3 and Java 1.8.0_121
Build and run Tests / BDD with Maven:   mvn clean install

## The Exercise

Using Java, write a simple program that calculates the price of a basket of shopping.
The solution should be accomplished in roughly two hours.


Items are presented one at a time, in a list, identified by name - for example "Apple" or "Banana".
Multiple items are present multiple times in the list,
so for example ["Apple", "Apple", "Banana"] is a basket with two apples and one banana.

Items are priced as follows:
 - Apples are 35p each
 - Bananas are 20p each
 - Melons are 50p each, but are available as ‘buy one get one free’
 - Limes are 15p each, but are available in a ‘three for the price of two’ offer

Given a list of shopping, calculate the total cost of those items.

## Assumptions

I've used an Enum for shopping cart items. This is purely to simplify that part of the example as a more detailed example would have to get into inventory, stock etc which seems to be outside the scope of this exercise

I've created a 'FixedPricingService' which is loaded with immutable prices and discounts on startup. It would be easy to swap this with a more involved solution as required but I've assumed this is out of scope.

As part of the above two points, I've just returned a 0 price for any of the items which didn't receive a price on startup

I haven't included any log statements, purely to keep me to the 2 hour window. I believe we discussed when and what to log in the phone interview

My last assumption is that a purely in-memory solution is fine. Again, easy to swap out with a more involved solution if required.

