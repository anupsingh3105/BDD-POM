Feature: Functionality on Amazon

  Background:
    Given user enter the login credentials
    When I am on the amazon page

  Scenario: Search the products
    When user click on search field
    Then grab all the items and click on the expected item
