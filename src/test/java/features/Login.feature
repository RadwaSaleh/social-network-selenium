Feature: Login
  This feature deals with the authentication functionality of the application

  Scenario Outline: Login with invalid username and password
    Given user navigates to login page
    When user enters invalid "<username>" and/or "<password>"
    And user clicks login button
    Then login should be unsuccessful
    Examples:
      | username         | password            |
      | tomsmith         | 1234                |
      | aquaUser         | SuperSecretPassword!|
      |                  |                     |