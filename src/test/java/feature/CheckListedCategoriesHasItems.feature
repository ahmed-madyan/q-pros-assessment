@Regression @Regression_FE
Feature: Check the listed Categories has Items

  @CheckListedCategoriesHasItems
  Scenario: Check the listed Categories has Items
    Given User navigated to the portal url
    When Navigated to phones category
    Then Validate that phones category has items
    When Navigated to laptops category
    Then Validate that laptops category has items
    When Navigated to monitors category
    Then Validate that monitors category has items