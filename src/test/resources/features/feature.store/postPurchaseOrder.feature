Feature: Testing Swagger petStore API create order
  @Swagger
  Scenario Outline: Post create new order with valid json
    Given Post create order with valid json "<filename>"
    When Send request post create order
    Then Should return status create code 200
#      And Response body name should be "<id>" and pet "<petId>" and qty "<qty>" and shipDate "<shipDate>" and status "<status>" and complete "<complete>"
    And Response body should be match with json schema
    Examples:
      | id  | petId | qty | shipDate | status |filename|
      | 1   | 2     |  3  ||        |        createOrder1.json          |
    |     |       |     ||        |          createOrder2.json                         |
      |     |       |     ||        |          createOrder3.json                         |

  @Swagger
  Scenario Outline: Post create new user with invalid json
    Given Post create order with invalid json "<filename>"
    When Send request post create order
    Then Should return status create code 400
    Examples:
      | name | job        |filename|
      |      | Pr0gr4mm3r |invalidCreateOrder1.json|
      |      | Pr0gr4mm3r |invalidCreateOrder2.json|
      |      | Pr0gr4mm3r |invalidCreateOrder3.json|
