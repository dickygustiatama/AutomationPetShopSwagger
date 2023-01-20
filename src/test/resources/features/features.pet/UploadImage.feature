Feature: Testing Petstore Swagger API for endpoint Upload an Image
  @Swagger
  Scenario: Post an image with valid parameter and body
    Given Base URL for upload an image with parameter "2", additionalMetadata as "private"
    When Send request post upload an image
    Then Should return status code 200
    And Validate json schema upload an image

  @Swagger
  Scenario: Post an image with invalid parameter
    Given Base URL for upload an image with parameter "a", additionalMetadata as "private"
    When Send request post upload an image
    Then Should return status code 404
    And Response body message should be "java.lang.NumberFormatException: For input string: \"a\""

  @Swagger
  Scenario: Post an image without parameter
    Given Base URL for upload an image with parameter "", additionalMetadata as "private"
    When Send request post upload an image
    Then Should return status code 404
    And Response body message should be "null for uri: http://petstore.swagger.io/v2/pet//uploadImage"

  @Swagger
  Scenario: Post an image without additionalMetadata in body
    Given Base URL for upload an image with parameter "2", additionalMetadata as ""
    When Send request post upload an image
    Then Should return status code 200
    And Validate json schema upload an image

  @Swagger
  Scenario: Post an image without file in body
    Given Base URL for upload an image with parameter "2", additionalMetadata as "private", but without body
    When Send request post upload an image
    Then Should return status code 400
    And Response body message should be "no file"

  @Swagger
  Scenario: Post an image without body
    Given Base URL for upload an image with parameter "2", additionalMetadata as "", but without body
    When Send request post upload an image
    Then Should return status code 400
    And Response body message should be "no data"