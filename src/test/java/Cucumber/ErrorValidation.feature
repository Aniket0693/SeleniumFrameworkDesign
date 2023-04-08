
@tag
Feature: Error Validation
  
  
  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given User lands on Ecommerce page
    When User logged in with Username <Username> and Password <Password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | Username  		|       Password |ProductName|
      | amp@xyz.com 	|     Aniket123 |ZARA COAT 3|
      