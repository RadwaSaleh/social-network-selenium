Feature: Login
  This feature deals with the authentication functionality of the application

  Background:
    Given user navigates to login page

  Scenario: Successful login with valid username and password
    When user enters valid credentials
    And  user clicks login button
    Then login should be successful

  Scenario Outline: Unsuccessful login with invalid username and password
    When user enters invalid "<username>" and/or "<password>"
    And user clicks login button
    Then login should be unsuccessful
    Examples:
      | username         | password            |
      | tomsmith         | 1234                |
      | aquaUser         | SuperSecretPassword!|
      |                  |                     |