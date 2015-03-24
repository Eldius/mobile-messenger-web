
Feature: Login

  Scenario: Test login with a valid user
    Given I open the home page
    When I try to login as 'admin' with '123' as my password
    Then I can see the logged user menu on the right

  Scenario: Test login with a invalid user
    Given I open the home page
    When I try to login as 'balrog' with '123' as my password
    Then I shall not pass
