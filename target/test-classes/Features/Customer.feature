Feature: Customers

#used to comment out in feature file 

Background:steps common for all scenario
		Given User launch chrome browser
    When User open URL: "https://admin-demo.nopcommerce.com/login"
    And user enters email as "admin@yourstore.com" and password as "admin"
    And click on login
    Then User can view Dashboad
    
	@Regression
  Scenario: Add New Customer
    
    When User click on customers Menu
    And click on customers Menu Item
    And click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And click on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    And Close Browser
    
  #refer session 4 for tags  for  @Sanity  & @Regression
  @Sanity  
  Scenario: Search Customer by Email
  Given User launch chrome browser
  When User open URL: "https://admin-demo.nopcommerce.com/login"
  And user enters email as "admin@yourstore.com" and password as "admin"
  And click on login
  Then User can view Dashboad
  When User click on customers Menu
  And click on customers Menu Item
  And Enter customer EMail
  When Click on search button
  Then User should found Email in the Search table
  And Close Browser