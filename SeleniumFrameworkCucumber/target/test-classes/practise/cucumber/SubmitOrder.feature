
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

Background:
	Given I landed on Ecommerce Page	

  @Regression
  Scenario Outline: Positive Test of Submitting the Order
    Given Logged in with username <username> and password <password>
    When I add product <productName> to cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmationPage

    Examples: 
      | username  				 | password    | productName	   |
      | jitendra@gmail.com | Test@123		 | ADIDAS ORIGINAL |
      
