@Regression @Regression_FE @Login
Feature: Log in

  Scenario: Validate register and login flow
    Given User navigated to the portal url
    When Login with existing user
    Then Validate user logged in successfully
