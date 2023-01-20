Feature: Testing Swagger petStore API DELETE Purchase Order
  @Tugas
    Scenario Outline: Delete order with valid id
      Given delete order with valid id "<id>"
      When Send request delete order
      Then Should return status delete order code 200
    Examples:
    |id|
    | 1 |
    |  2 |
    |   3 |

  @Tugas
  Scenario Outline: Delete order with invalid id
    Given delete order with invalid id "<id>"
    When Send request delete order
    Then Should return status delete order code 404
    Examples:
      |id|
      | 98282 |
      |  ab |
      |   #$ |