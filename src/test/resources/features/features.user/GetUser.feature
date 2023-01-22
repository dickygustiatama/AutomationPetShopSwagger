Feature: Testing Petstore Swagger API for endpoint Get User by Username
  @Swagge
  Scenario: Get User by valid username
    Given get User with input username "tamabunta"
    And Send request get User with input username
    Then Should return status code 200
    And Response body should be the same username as "tamabunta"
    Then validate json schema get user by valid username

  @Swagger
  Scenario: Get User by invalid username
    Given get User with input username "User1"
    And Send request get User with input username
    Then Should return status code 404
    And response body have message "User not found"
    Then validate json schema get user by invalid username

  @Swagger
  Scenario: Get User by email
    Given get User with input username as email "tama@gmail.com"
    And Send request get User with input username as email
    Then Should return status code 404
    And response body have message "User not found"
    Then validate json schema get user by invalid username