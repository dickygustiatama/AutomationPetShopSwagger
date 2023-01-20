Feature: Testing Petstore Swagger API for endpoint Update Pet with Form Data
  @Swagger
  Scenario: Post update pet with valid parameter and body
    Given Base URL for update with parameter "2", name as "cat" ,status as "pending"
    When Send request post update pet
    Then Should return status code 200
    And Response body message should be the same as id "2"
    And Validate json schema update pet