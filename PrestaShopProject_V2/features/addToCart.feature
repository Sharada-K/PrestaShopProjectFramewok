@feature2
Feature: Add to cart

Background: 
Given Launch any browser
And Open URL

 Scenario:
    Given I am on the locate page
    When I search for poster item
    And I click on third product
    And I change the dimension to second option
    And I change the quantity to 5
    And I click on add to cart button
    Then I validate that item added to the cart successfully
    And I close the browser

	Scenario: 
	  Given I am on the item search page
    When I search for tshirt
    And I click on the first product
    And I click on Add to cart
    And I click on proceed to check out button
    Then I validate the name and quantity of the item
    And I close the Browser

 