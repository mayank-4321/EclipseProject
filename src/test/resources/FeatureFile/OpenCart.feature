Feature: Test opencart application

  Scenario: Test the registration process for new user
    Given open the application with url "https://tutorialsninja.com/demo/index.php?route=account/register"
    When user enter fills all the required enteries
      | fname     | lname | email            | tele       | pwd     | cpwd    |
      | Abhimanyu | Singh | abs123@gmail.com | 9898989898 | test123 | test123 |
    When user click on yes Newsletter
    When user click on agree private policy
    When user click on continue button
    Then user should able to register

  Scenario: Test login functionality for registered user
