Feature: send sample GET call
Background:
  Given I GET a list of existing books
  And I create a new Book
  And I verify book created

  Scenario: sending sample DELETE
    Given I send generic Delete call on the book
    Then operation is successful
    And I receive Delete response
    And I verify the book was removed

  Scenario: sending same DELETE twice
    Given I GET a list of existing books
    When I send generic Delete call on the book
    Then operation is successful
    And I receive Delete response
    And I verify the book was removed
    When I send generic Delete call on the book
    # to be determined if error is the correct behaviour
    #Then I receive error
