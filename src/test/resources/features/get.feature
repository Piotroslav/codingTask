Feature: send sample GET call

  Scenario: sending sample GET
    Given I send generic GET call
    Then operation is successful
    And I GET a list of existing books

  Scenario: sending sample GET by Id
    Given I GET a list of existing books
    When I send generic GET by Id call Existing
    Then operation is successful
    And I GET that book

  Scenario: sending sample GET by Id
    Given I GET a list of existing books
    When I send generic GET by Id call not Existing
    #to be determined if operation should be successful
    #Then operation is successful?
    #And I GET error or empty book