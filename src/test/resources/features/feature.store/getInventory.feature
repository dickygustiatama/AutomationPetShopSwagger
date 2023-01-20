Feature: Testing Swagger petStore API DELETE Purchase Order
  @Tugas
  Scenario:
    When Send request get store inventory
    Then Should return status get inventory code 200
    And Validate response body with json schema