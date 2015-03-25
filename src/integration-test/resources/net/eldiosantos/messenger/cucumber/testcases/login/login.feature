
Feature: Login

  Scenario: Test login with a valid user
    Given I open the home page
    When I try to login as 'admin' with '123' as my password
    And I take a snapshot and save on the file 'login_valid_user.png'
    Then I can see the logged user menu on the right
    And I take a snapshot and save on the file 'test_login_with_valid_user.png'
    And I close the browser

  Scenario: Test login with a invalid user
    Given I open the home page
    When I try to login as 'balrog' with '123' as my password
    And I take a snapshot and save on the file 'login_invalid_user.png'
    Then I shall not pass
    And I take a snapshot and save on the file 'test_login_with_invalid_user.png'
    And I close the browser

  Scenario: Test login page
    Given I open the home page
    When I click on the login menu
    Then I can see the login form
    And I take a snapshot and save on the file 'test_login_page.png'
    And I close the browser
