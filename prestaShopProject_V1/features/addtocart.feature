Feature: Place an order in PrestaShop
 
 @ExecuteBeforeFeature
 Scenario:
    Given I open URL
    And I create account in PrestaShop
    When I search for poster item
    And I add third product to the cart from the search result
    And I change the dimension to second element
    And I change the quantity to 5
    And I add item to shopping cart
    Then I validate that item added to the cart successfully




@ExecuteAfterFeature
	Scenario: 
	Given An item on the locate page
	When I click on proceed to check out button
	Then I verify product details

  