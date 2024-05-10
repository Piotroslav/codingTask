Feature: send sample PUT call

  Scenario: sending sample PUT
    Given I GET a list of existing books
    When I send generic PUT call for last book
    Then I receive PUT response
    And I verify the book update


    Scenario: checking if PUT can create a new book
      Given I GET a list of existing books
      When I send generic PUT call for nextId book
      Then I receive PUT response
      And I verify the book exist

  Scenario: checking if PUT can update the book with ID of an existing book
    Given I GET a list of existing books
    When I send generic PUT call for existing book with existingId
    Then I receive PUT response
    And I verify the book exist

  Scenario: checking if PUT can update the book with null ID
    Given I GET a list of existing books
    When I send generic PUT call for existing book with null as Id
    Then I receive PUT response
    And I verify the book exist