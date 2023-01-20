Feature: Testing Post update pet with form data
  @Swagger
  Scenario: Post update pet with valid parameter and body
    Given Base URL for update pet with valid parameter "2", name as "caty" and status as "pending"
    When Send request post update pet
    Then Should return status code 200

