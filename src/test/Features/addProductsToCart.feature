Feature: As a user I should be able add Products to Cart
  Background:
    Given User is on the homepage "https://www.saucedemo.com"
    When the user enters username "standard_user"
    And the user enters password "secret_sauce"
    When  the user clicks login button
    Then the user should see the "Products" page
    @add
    Scenario:
      Given user is in the Products page
      Then the user should see the "Products" page
      When the user clicks on  "Sauce Labs Backpack"
      Then the user clicks add to cart button
      Then the product is added to cart
      And the cart is updated

