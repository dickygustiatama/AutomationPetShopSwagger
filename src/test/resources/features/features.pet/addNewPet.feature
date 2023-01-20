Feature: Post new pet to the store
  @Project @Positive
  Scenario: Post new pet with valid body
    Given Post create new pet with valid json
    When send request post create new pet
    Then Should return status code 200
    And Validate json schema create new pet

  @Project @Negative
    Scenario: Post new pet without ID
    Given Post create new pet without ID
    When send request post create new pet
    Then Should return status code 200

  @Project @Negative
    Scenario: Post new pet without name in body
    Given Post create new pet without name
    When send request post create new pet
    Then Should return status code 400

  @Project @Negative
    Scenario: Post new pet without photoUrls
    Given Post create new pet without photoUrls
    When send request post create new pet
    Then Should return status code 400

  @Project @Negative
    Scenario: Post new pet without tags
    Given Post create new pet without tags
    When send request post create new pet
    Then Should return status code 400

  @Project @Negative
    Scenario: Post new pet without status
    Given Post create new pet without status
    When send request post create new pet
    Then Should return status code 400

  @Project @Negative
    Scenario: Post new pet with invalid data type for id in body
    Given Post create new pet with invalid data type ID
    When send request post create new pet
    Then Should return status code 400

  @Project @Negative
    Scenario: Post new pet without body
    Given Post create new pet with null JSON in body
    When send request post create new pet
    Then Should return status code 400



  @Project @Negative
    Scenario: Post new pet with empty JSON in body
    Given Post create new pet with empty JSON in body
    When send request post create new pet
    Then Should return status code 400