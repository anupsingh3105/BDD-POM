Feature: Signup functionality on Instagram

  Scenario Outline: Signup using email
    Given I am on the instagram page
    When user clicks on signup button
    And user fill up the sign up details
    And user fills up birth details with day <day>, month <month>, and year <year>
    And saves username,password creds in file
     Then user navigates to email to get otp
#    When user enters otp
 #   Then user lands to instagram home page

    Examples:
      | day | month | year |
      | 5   | MAY   | 1996 |