Feature: Test Google application.

  Background: 
    Given Open google application

  Scenario: Test for google homepage title
    #Given Open google application
    When Get the application title
    Then Application should be Google

  Scenario: Test for google search with valid keyword
    #Given Open google application
    When User enter valid keyword as "Cucumber" in the search box
    Then User should get the appropriate search result
