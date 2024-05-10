Feature: exploratory testing

  Scenario: sending sample GET
    Given I send generic GET call
    When I receive GET response
    When I create a new Book
    Then operation is successful
  And I verify the book exist
    And I can find the Book by Id
    When I update the Book
    Then operation is successful
    And Book is updated
    When I update the Book
    Then operation is successful
    And Book is updated
    When I delete the Book
    Then operation is successful
    And Book is deleted
