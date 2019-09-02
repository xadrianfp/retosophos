#Author: adrianfpuerta@gmail.com
#Each feature contains one feature
#Feature files use Gherkin language - bussiness language
Feature: Plazavea
	As a webuser
	I want to use Plazavea
	to buy different products 

  #A feature may have given different specific scenarios
  #Scenarios use Given-When-Then structure
  @tag1
  Scenario Outline: Buy a product on Plazavea
    Given that adrian wants to go to Plazavea in the supermarket section
    When he goes to fruits section
    And he adds an orange on oranges page
    And he fills the email to buy with <email> 
    Then i should see the product orange in the shoppingcar

   Examples: 
      | email  | 
      | xadrianfp@gmail.com | 
      