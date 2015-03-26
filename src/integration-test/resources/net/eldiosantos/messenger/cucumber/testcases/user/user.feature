Feature: User management

  Scenario: Create a new user and test menu items
    Given I open the home page
    When I try to login as 'admin' with '123' as my password
    And open the admin console
    And select the open user registration option
    And click on save config button
    And log out from the system
    And click on the sign up button
    And create a user with login "case", password "wintermute" and email "case@mailinator.com"
    And click save user
    And I try to login as 'case' with 'wintermute' as my password
    Then I can see the logged user menu on the right
    And I can't see the admin menu item
    And I take a snapshot and save on the file 'open_user_registration.png'
    And I close the browser

  Scenario: Create a new user and test profile edition
    Given I open the home page
    When I try to login as 'admin' with '123' as my password
    And open the admin console
    And select the open user registration option
    And click on save config button
    And log out from the system
    And click on the sign up button
    And create a user with login "belkar", password "bitterleaf" and email "belkar@mailinator.com"
    And click save user
    And I try to login as 'belkar' with 'bitterleaf' as my password
    And open the logged user menu and click on the profile item
    And change my password to "strongP@ssword!"
    And click save user
    And log out from the system
    And I try to login as 'belkar' with 'strongP@ssword!' as my password
    Then I can see the logged user menu on the right
    And I take a snapshot and save on the file 'open_user_registration.png'
    And I close the browser
