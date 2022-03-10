Feature: Purchase TShirt and Update First Name 
	Description:This feature is to test the product purchase, verifies Order and Update First Name and Verify Update name on header 
   

Background: User log in to the site 
	Given User is on the landing page 
	And Log in with a valid user id and password
	And Verify my account page after login
	
@OrderTShirt 
Scenario: Purchase Tshirt and verify the order 
	And Click on the T-shirts category Link 
	When Search with "Faded Short Sleeve T-shirts" for purchase 
	Then click on proceed to checkout button and complete check out process 
	
@UpdatePersonalInfo 
Scenario: Update First Name from Personal information and Verify updated FirstName 
	And User click on my personal info button
	When Landed on My personal info page
	Then Update firstname with "David" and currentpassword "Selenium123." 
	And Verify udpated first name "David" 
    