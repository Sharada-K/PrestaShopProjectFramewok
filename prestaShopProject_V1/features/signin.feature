Feature: Sign in feature

Background: 
Given Launch any browser
And Open URL

  Scenario: Create new account in prestashop
    Given I have active email address
    When I click on SignIn link
    And I click on create another account
    And I enter firstname and lastname
    And I enter email address and new password
    And I enter birthday date
    And I check the terms and conditions checkbox
    And I click on save button
    Then I validate that signed in successfully with the above details

  