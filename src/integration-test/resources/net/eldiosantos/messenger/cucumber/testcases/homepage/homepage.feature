
Feature: Home page

  Scenario: Hitting the system home page
    Given I open the home page
    Then I can see the login fields
    And I take a snapshot and save on the file 'home.png'
    And I close the browser
