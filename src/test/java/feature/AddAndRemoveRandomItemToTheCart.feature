@Regression @Regression_FE
Feature: Add And Remove Random Item To The Cart

  @AddAndRemoveRandomItemToTheCart
  Scenario: Add And Remove Random Item To The Cart
    Given User navigated to the portal url
    When Select phone product
    Then Validate user navigated to the product page
    When Phone added to the cart
    Then Alert pop up should be displayed with a success message
    When User accepts the alert pop
    And User navigated to the cart
    Then Validate that phone exists in the cart
    When Remove the product
    Then Cart Should be Empty

  @PlaceOrder
  Scenario: Place order
    Given User navigated to the portal url
    When Select phone product
    Then Validate user navigated to the product page
    When Phone added to the cart
    Then Alert pop up should be displayed with a success message
    When User accepts the alert pop
    And User navigated to the cart
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
