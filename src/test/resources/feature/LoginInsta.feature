Feature: Login functionality on Insta

  Scenario: Successful login with valid credentials
    Given I am on the insta login page
    When user reads files to get useranme and password
    And user enter creds on login page
    And user lands to home page
    Then user logs out