Feature: Testing Testing Petstore Swagger API for endpoint Post Create User With Array
  @Swagger
  Scenario: Post create user with array complete body
    Given Base URL with valid and complete body
    When send request POST user with array
    Then Should return status code 200
    And response body have message "ok"
    And validate json schema post create user input array

  @Swagger
  Scenario: Post create user without id
    Given Base URL without id
    When send request POST user with array
    Then Should return status code 200
    And response body have message "ok"
    And validate json schema post create user input array

  @Swagger
  Scenario: Post create user without username
    Given Base URL without username
    When send request POST user with array
    Then Should return status code 200
    And response body have message "ok"
    And validate json schema post create user input array

  @Swagger
  Scenario: Post create user without first name
    Given Base URL without first name
    When send request POST user with array
    Then Should return status code 200
    And response body have message "ok"
    And validate json schema post create user input array

  @Swagger
  Scenario: Post create user without last name
    Given Base URL without last name
    When send request POST user with array
    Then Should return status code 200
    And response body have message "ok"
    And validate json schema post create user input array

  @Swagger
  Scenario: Post create user without email
    Given Base URL without email
    When send request POST user with array
    Then Should return status code 200
    And response body have message "ok"
    And validate json schema post create user input array

  @Swagger
  Scenario: Post create user without password
    Given Base URL without password
    When send request POST user with array
    Then Should return status code 200
    And response body have message "ok"
    And validate json schema post create user input array

  @Swagger
  Scenario: Post create user without phone
    Given Base URL without phone
    When send request POST user with array
    Then Should return status code 200
    And response body have message "ok"
    And validate json schema post create user input array

  @Swagger
  Scenario: Post create user without user status
    Given Base URL without user status
    When send request POST user with array
    Then Should return status code 200
    And response body have message "ok"
    And validate json schema post create user input array

  @Swagger
  Scenario: Post create user with invalid variable
    Given Base URL with invalid variable
    When send request POST user with array
    Then Should return status code 200
    And response body have message "ok"
    And validate json schema post create user input array

  @Swagger
  Scenario: Post create user without body
    Given Base URL without body
    When send request POST user with array
    Then Should return status code 405
    And response body have message "no data"
    And validate json schema post create user input array