Feature: Testing Swagger petStore API GET Purchase Order
  @Tugas
  Scenario Outline: get order with valid id
    Given get order with valid id "<id>"
    When Send request get order
    Then Should return status get order code 200
    And validate response body with json schema
    Examples:
      | id |
      | 1  |
      | 2  |
      | 3  |

  @Tugas
  Scenario Outline: get order with invalid id
    Given get order with invalid id "<id>"
    When Send request get order
    Then Should return status get order code 404
    Examples:
      | id |
      | 98 |
      | #& |
      | ab |

  @Tugas
  Scenario Outline: get order with invalid id
    Given get order with invalid id "<id>"
    When Send request get order
    Then Should return status get order code 405
    Examples:
      | id |
      |    |
