Feature: Test CRM application

  Background: 
    Given open CRM application


  Scenario: Test for signin link
    When user click on sisgn link
    Then use should naviagate to login page


  Scenario: Test for login with valid Credentials
    When user navigated to login page
    When user enters valid email "test@gmail.com" and password "test123" and click on submit button
    Then user should able to login and  navigate to customers page

