Feature: send sample POST call

  Scenario: sending sample POST
    Given I GET a list of existing books
    When I send generic POST call
    Then operation is successful
    And I receive POST response
    And I verify the book exist

  Scenario: sending same consecutive POSTs
    Given I GET a list of existing books
    When I send generic POST call
    Then operation is successful
    And I receive POST response
    And I verify the book exist
    When I send generic POST call
    Then operation is successful
    And I receive POST response
    And I verify the book exist