Feature: Delete pet
  @Swagger @Positive
    Scenario: Delete pet with valid ID
    Given Delete user with valid id 2
    When Send request delete pet
    Then Should return status code 200

  @Swagger @Negative
    Scenario: Delete pet with invalid / unregistered ID
    Given Delete user with unregistered id 234762785
    When Send request get pet
    Then Should return status code 404

  @Swagger @Negative
    Scenario: Delete pet with invalid ID
    Given Delete user with invalid id "doggie"
    When Send request get pet
    Then Should return status code 404

