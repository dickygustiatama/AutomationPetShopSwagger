Feature: Testing Testing Petstore Swagger API for endpoint Post Create List Of User
  @Swagger
  Scenario: Post create list of user with array complete body
    Given Base URL list of user with valid and complete body
    When send request POST list of user with array
    Then Should return status code 200
    And response body have message "ok"
    And validate json schema post create list of user input array

  @Swagger
  Scenario: Post create list of user without id
    Given Base URL list of user without id
    When send request POST list of user with array
    Then Should return status code 200
    And response body have message "ok"
    And validate json schema post create list of user input array

  @Swagger
  Scenario: Post create list of user without username
    Given Base URL list of user without username
    When send request POST list of user with array
    Then Should return status code 200
    And response body have message "ok"
    And validate json schema post create list of user input array

  @Swagger
  Scenario: Post create list of user without first name
    Given Base URL list of user without first name
    When send request POST list of user with array
    Then Should return status code 200
    And response body have message "ok"
    And validate json schema post create list of user input array

  @Swagger
  Scenario: Post create list of user without last name
    Given Base URL list of user without last name
    When send request POST list of user with array
    Then Should return status code 200
    And response body have message "ok"
    And validate json schema post create list of user input array

  @Swagger
  Scenario: Post create list of user without email
    Given Base URL list of user without email
    When send request POST list of user with array
    Then Should return status code 200
    And response body have message "ok"
    And validate json schema post create list of user input array

  @Swagger
  Scenario: Post create list of user without password
    Given Base URL list of user without password
    When send request POST list of user with array
    Then Should return status code 200
    And response body have message "ok"
    And validate json schema post create list of user input array

  @Swagger
  Scenario: Post create list of user without phone
    Given Base URL list of user without phone
    When send request POST list of user with array
    Then Should return status code 200
    And response body have message "ok"
    And validate json schema post create list of user input array

  @Swagger
  Scenario: Post create list of user without user status
    Given Base URL list of user without user status
    When send request POST list of user with array
    Then Should return status code 200
    And response body have message "ok"
    And validate json schema post create list of user input array

  @Swagger
  Scenario: Post create list of user with invalid variable
    Given Base URL list of user with invalid variable
    When send request POST list of user with array
    Then Should return status code 200
    And response body have message "ok"
    And validate json schema post create list of user input array

  @Swagger
  Scenario: Post create list of user without body
    Given Base URL list of user without body
    When send request POST list of user with array
    Then Should return status code 405
    And response body have message "no data"
    And validate json schema post create list of user input array