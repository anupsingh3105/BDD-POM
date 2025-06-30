Feature: Functionality on Amazon

  Background:
    Given user enter the login credentials
    When I am on the amazon page

  Scenario Outline: Search the products
    When user click on search field
    Then grab all the items and click on the expected item
    When user searches for "<product>" using the search bar

    Examples:
      | product |
      | laptop  |
