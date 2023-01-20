Feature: Testing Petstore Swagger API for endpoint Update Pet with Form Data
  @Swagger
  Scenario: Post update pet with valid parameter and body
#    Given Base URL for new pet with valid and complete body
#    And Send request post add new pet
    Given Base URL for update pet with valid parameter "2", name as "cat" and status as "pending"
    When Send request post update pet
    Then Should return status code 200
    And Response body message should be the same as id "2"
    And Validate json schema update pet