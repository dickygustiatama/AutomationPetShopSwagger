Feature: Testing Petstore Swagger API for endpoint Login User
  @Swagger
  Scenario: Login user with valid username and password
    Given Base URL for Login User with username and password
    When Send request Login User
    Then Should return status code 200
    And Validate json schema Inventory Status

  @Swagger
  Scenario: Login user with invalid username but valid password
    Given Base URL for Login User with invalid username but valid password
    When Send request Login User
    Then Should return status code 400
    And Validate json schema Inventory Status

  @Swagger
  Scenario: Login user with valid username but invalid password
    Given Base URL for Login User with valid username but invalid password
    When Send request Login User
    Then Should return status code 400
    And Validate json schema Inventory Status

  @Swagger
  Scenario: Login user with out body
    Given Base URL for Login User without body
    When Send request Login User
    Then Should return status code 400
    And Validate json schema Inventory Status