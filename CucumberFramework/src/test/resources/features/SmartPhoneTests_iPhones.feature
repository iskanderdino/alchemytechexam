@regression @smartphones @iphones
Feature: This feature will test the functionalities in the Smartphone webpage
  Background:
    Given I visit Back Market website
    And I close cookie modal on the webpage
    When I click "Smartphones" menu in the webpage

  @smoke
  Scenario: Verify accessibility of iPhone page
    Then I should be redirected to "Smartphones" webpage

  @filter
  Scenario Outline: Buy an iphone with specific memory and phone condition and has damage warranty
    And I click "<brand>" in the "Brand" search filter section
    And I click "<storage>" in the "Storage" search filter section
    And I click "<conditions>" option in the "Condition" filter section
    And I click the Staff pick product in the webpage
    And I click Buy button in the Product Details page
    And I click No button in the Trade-in offer modal
    And I click Go to cart button in the Product Details page
    Then the phone memory should display "<storage>" GB
    And the phone condition should display "<conditions>"
    When I tick "<insurance>" Damage Cover in the coverage option
    Then the Summary section should display "<insurance>" Damage Cover warranty
    And the Total Price should display updated the price with "<insurance>" Damage Cover warranty
    Examples:
    | brand  | storage | conditions | insurance |
    | Apple  | 128     | Good       | 12-month  |
    | Huawei | 64      | Excellent  | 24-month  |