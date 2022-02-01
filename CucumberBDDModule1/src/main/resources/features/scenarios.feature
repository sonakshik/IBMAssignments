@SauceLabs_demo_scenarios
Feature: Checkout Scenario for Sauce Labs

  Background: Logged in user on Saucelabs
   Given I  navigate to SauceLabs page
    When I login as a register user
    
  @SCheckout
  Scenario: Scenario_Select and checkout   
    And I select the "Sauce Labs Bolt T-Shirt" from the items
    And I select the "Sauce Labs Onesie" from the items
    Then I confirm the cart items
    When I proceed to checkout
    Then I should see checkout completion page
    
  @RemoveAndCheckout
   Scenario: Scenario_Remove and checkout   
    And I select the "Sauce Labs Bolt T-Shirt" from the items
    And I select the "Sauce Labs Bike Light" from the items
    Then I confirm the cart contents
    Then I remove "Sauce Labs Bike Light" from the cart
    Then I select the "Sauce Labs Backpack" from the items
    Then I confirm the cart contents
    When I proceed to checkout
    Then I should see checkout completion page
    
   @SelectLowestPriceAndCheckout
   Scenario: Scenario_Select Lowest Price and Checkout  
  	And I select 2 lowest priced products
    Then I confirm the cart contents
    When I proceed to checkout
    Then I should see checkout completion page
    
