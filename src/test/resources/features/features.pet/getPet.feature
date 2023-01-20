Feature: Get find pet
  @Swagger @Positive
    Scenario: Find pet with valid ID
    Given Get pet id 2
    When Send request get pet
    Then Should return status code 200
    And Validate json schema find pet with ID

  @Swagger @Negative
    Scenario: Find pet by name
    Given Get pet invalid id "kelinci"
    When Send request get pet
    Then Should return status code 404

  @Swagger @Negative
    Scenario: Find pet with invalid id
    Given Get pet id 8976
    When Send request get pet
    Then Should return status code 404

  @Swagger @Negative
    Scenario: Find pet with special character
    Given Get pet invalid id "&-(3"
    When Send request get pet
    Then Should return status code 404

  @Swagger @Negative
    Scenario: Find pet without body
    Given Get find pet without body
    When Send request get pet
    Then Should return status code 404

    #get by status

  @Swagger @Positive
    Scenario Outline: Find pet by Status available
    Given Get find pet with status "<status>"
    When Send request get pet with status
    Then Should return status code 200
    Examples:
      | status    |  |
      | available |  |
      | pending   |  |
      | sold      |  |





