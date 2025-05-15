@TUIHotels
Feature: Login Functionality

    @Login
    Scenario: User logs into the app with valid credentials
    Given user launch the application
    When user logs into the app with valid credentials
    #Then user lands on dashboard page
    #And user close the application
    
    @Dashboard
    Scenario: User on Dahsboard Page
    #Given user launch the application
    #When user logs into the app with valid credentials
    Then user lands on dashboard page
    And user close the application
