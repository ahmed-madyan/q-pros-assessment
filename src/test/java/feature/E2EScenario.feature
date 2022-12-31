@Regression @Regression_FE
Feature: Register and Log in

  @Register
  Scenario: Validate register
    Given User navigated to the portal url
    When Username sign up with new generate user data
    Then Validate sign up successful message appears in JS alert
    And Accept the confirmation alert

  @Login
  Scenario: Validate login flow
    Given User navigated to the portal url
    When Login with existing user
    Then Validate user logged in successfully