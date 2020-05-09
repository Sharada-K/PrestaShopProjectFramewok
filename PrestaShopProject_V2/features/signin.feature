Feature: Sign in feature

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
    
  Scenario: Login with the exising account
  Given I have account in prestashop
  Then I click on Signin link
  And I enter email address in the email address field
  And I enter password in the password field
  And I click on signin button
  Then validate that logged in successfully with the above credentials

  