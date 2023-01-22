Feature: Testing Petstore Swagger API for endpoint Delete User
  @Swagger
  Scenario: Delete user by valid username
#    Given Base URL for create a user with valid and complete body
#    And Send request post create a user
    Given Base URL for delete user with valid username "tamabunta"
    When Send request delete user
    Then Should return status code 200
    And Response body should be the same as username "tamabunta"
    And Validate json schema delete user

  @Swagger
  Scenario: Delete user by invalid username
    Given Base URL for delete user with valid username "sdjgkhjksdb"
    When Send request delete user
    Then Should return status code 404