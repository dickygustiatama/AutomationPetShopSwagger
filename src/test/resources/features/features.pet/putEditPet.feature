Feature: Put update pet
  @Swagger @Positive
    Scenario: Update pet with valid ID
    Given Put update pet with valid id
    When Send request put update pet by ID
    Then Should return status code 200
    And Validate json schema update pet

  @Swagger @Negative
    Scenario: Update pet with invalid ID
    Given Put update pet with invalid ID
    When Send request put update pet by ID
    Then Should return status code 400

  @Swagger @Negative
  Scenario: Update pet with unregistered ID
    Given Put update pet with unregistered ID
    When Send request put update pet by ID
    Then Should return status code 400

