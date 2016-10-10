Feature: Login Module
  Test Login module functionality

  Scenario: Login into yahoo
    Given Browser is open
    When I login into yahoo mail
    Then I am able to see the main page