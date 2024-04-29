Feature:User should login successfully
@login
  Scenario:Verify valid login
    Given User is on the homepage "https://www.saucedemo.com"
    When the user enters username "standard_user"
    And the user enters password "secret_sauce"
    When  the user clicks login button
    Then the user should see the "Products" page
@login
    Scenario: Verify Invalid login
      Given User is on the homepage "https://www.saucedemo.com"

      When  the user clicks login button
      But the user should see the error message "Epic sadface: Username is required"

