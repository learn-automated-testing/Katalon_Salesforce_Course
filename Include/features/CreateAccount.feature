#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Login functionality for the web application
	
	
  Scenario: Successful login with valid credentials
    Given I navigate to the login page
    When I enter valid credentials
    Then I should be redirected to the homepage

  Scenario: Unsuccessful login with invalid credentials
    Given I navigate to the login page
    When I enter invalid credentials
    Then I should see an error message