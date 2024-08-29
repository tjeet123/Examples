
@tag
Feature: To check Error Validation to Ecommerce website
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I landed on Ecommerce Page
    When Logged in with username <username> and password <password>
    Then verify the error message "Incorrect email or password."

    Examples: 
      | username  				 | password | 
      | jitendra@gmail.com | test1234 | 
      
