Feature: Get Current Air Quality Data
@smoke
  Scenario: Get current air quality data of a particular post code
    Given I send a get air quality request to weatherbit for post code 28546
    Then the API should return status 403
    And Response should contain Country code "null"