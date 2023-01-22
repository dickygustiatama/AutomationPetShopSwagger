Feature: Testing Petstore Swagger API for endpoint Put Update User
  @Swagge
  Scenario: Put Update User with valid username
    Given put update user with valid username "tamabunta"
    When Send request put update user
    Then Should return status code 200
    And Validate json schema put update user

  @Swagge
  Scenario: Put Update User with invalid username
    Given put update user with invalid username "Uregistered1"
    When Send request put update user
    Then Should return status code 404
    And Response body message should be "User not found"
    And Validate json schema put update user