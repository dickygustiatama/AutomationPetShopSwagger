Feature: Testing Petstore Swagger API for endpoint Update Pet with Form Data
  @Swagger
  Scenario: Post update pet with valid parameter and body
    Given Base URL for update with parameter "2", name as "cat" ,status as "pending"
    When Send request post update pet
    Then Should return status code 200
    And Response body message should be the same as id "2"
    And Validate json schema update pet

  @Swagger
  Scenario: Post update pet with invalid parameter
    Given Base URL for update with parameter "i", name as "cat" ,status as "available"
    When Send request post update pet
    Then Should return status code 404

  @Swagger
  Scenario: Post update pet with invalid data type
    Given Base URL for update with parameter "2", name as "1" ,status as "available"
    When Send request post update pet
    Then Should return status code 400

  @Swagger
  Scenario: Post update pet without parameter
    Given Base URL for update with parameter "", name as "cat" ,status as "available"
    When Send request post update pet
    Then Should return status code 404

  @Swagger
  Scenario: Post update pet with valid parameter without name
    Given Base URL for update with parameter "i", name as "" ,status as "available"
    When Send request post update pet
    Then Should return status code 404

  @Swagger
  Scenario: Post update pet with valid parameter without status
    Given Base URL for update with parameter "i", name as "cat" ,status as ""
    When Send request post update pet
    Then Should return status code 400

  @Swagger
  Scenario: Post update pet with valid parameter without body
    Given Base URL for update with parameter "", name as "" ,status as ""
    When Send request post update pet
    Then Should return status code 400

  @Swagger
  Scenario: Post update pet with invalid parameter
    Given Base URL for update with parameter "i", name as "cat" ,status as "available"
    When Send request post update pet
    Then Should return status code 404

