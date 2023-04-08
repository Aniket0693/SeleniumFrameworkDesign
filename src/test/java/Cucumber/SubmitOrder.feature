@tag
Feature: Purchase theorder from Ecommerce Website
  I want to use this template for my feature file
  
  
  Background:
  Given User lands on Ecommerce page
  
  @Regression
  Scenario Outline: Positive test of submitting the order
    Given User logged in with Username <Username> and Password <Password>
    When User add the product <ProductName> to cart
    And Checkout <ProductName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmation Page

    Examples: 
      | Username  		|       Password |ProductName|
      | amp@xyz.com 	|     Aniket.123 |ZARA COAT 3|
      | aniket@qwe.qas|     Aniket.123 |ADIDAS ORIGINAL|