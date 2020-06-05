Feature: Pokedex so far

  Scenario: The pokedex is returned as it is so far
    When a request is received to the home endpoint
    Then a 200 response is returned
    And it contains Hello World