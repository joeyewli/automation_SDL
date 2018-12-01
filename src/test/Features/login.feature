@logins
Feature: Login tests
  @login
  Scenario: Good Login
    Given I am on SDL login page
    When I enter my username - JoeLi.PM@sdl.com in SDL
    And I enter my password - Appian2018 in SDL
    And I click login in SDL
    Then I will enter the homepage

    @logout
    Scenario: Logout
      Given I am logged in as a PM
      When I logout
      Then I return to the login page