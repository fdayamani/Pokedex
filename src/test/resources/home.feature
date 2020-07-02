Feature: Home

  Scenario: The home endpoint returns Hello World
    When a request is received to the home endpoint
    Then a 200 response is returned
    And it contains Hello World