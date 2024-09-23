Feature: Test OrangeHRM application

Background:
Given Open OrangeHRM application with "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
  Scenario: Test Login Page
   # Given Open OrangeHRM application with "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When User enters valid userid "Admin" and password "admin123" and click on login button
    Then user should navigate to Dashboard page

  Scenario: Test Logout Page
    Given user already logined with valid username "Admin" and password "admin123"
    When user click on profile logo and click on logout
    Then user should be able to checkout and navigate to login page
