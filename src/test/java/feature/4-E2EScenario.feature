@Regression @Regression_FE
Feature: E2E

  @E2E
  Scenario: E2E
    Given User navigated to the portal url
    When Username sign up with new generate user data
    Then Validate sign up successful message appears in JS alert
    And Accept the confirmation alert
    When Login with the new generated username
    When User navigated to home tap
    When Select phone product
    Then Validate user navigated to the product page
    When Phone added to the cart
    Then Alert pop up should be displayed with a success message
    When User accepts the alert pop
    And User navigated to the cart
    Then Validate that phone exists in the cart
    When Remove the product
    Then Cart Should be Empty
    When User navigated to home tap
    When Select phone product
    Then Validate user navigated to the product page
    When Phone added to the cart
    Then Alert pop up should be displayed with a success message
    When User accepts the alert pop
    And User navigated to the cart
    And Place order
    And Complete purchase
    Then Validate purchase success message
    Then User navigated to the portal url