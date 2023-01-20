Feature: Testing Petstore Swagger API for endpoint Logout User
  @Swagger
  Scenario: Logout User
    Given Base URL for Logout
    When Send request Logout without parameter
    Then Should return status code 200
    And Validate json schema Logout