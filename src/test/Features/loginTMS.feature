@logins @TMS
Feature: Login tests
  @login
  Scenario: Good Login
    Given I am on dev TMS login page
    When I enter my username - stewilson@sdl.com in TMS
    And I enter my password - P@ssw0rd123 in TMS
    And I click login in TMS
    Then I will enter TMS homepage

  @Test
  Scenario: Create Job
    Given I am logged in as PJM authorise in TMS
    When I select Create Job


  @logout
  Scenario: Logout
    Given I am logged in as a PM
    When I logout
    Then I return to the login page