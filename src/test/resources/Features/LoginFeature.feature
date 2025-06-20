
Feature: login
#used to comment out in feature file 
  Scenario: Successful login with valid credentials by behaviour driven test

    Given User launch chrome browser
    When User open URL: "https://admin-demo.nopcommerce.com/login"
    And user enters email as "admin@yourstore.com" and password as "admin"
    And click on login
    Then page title should be "Dashboard / nopCommerce administration"
    When user click on log out link
    Then Page title should be "Your store.Login"
    And Close Browser
    
    
    
    
    
    #Scenario Outline:Successful login with valid credentials with data driven testing
    
    #Given User launch chrome browser
    #When User open URL: "https://admin-demo.nopcommerce.com/login"
    #And user enters email as "<email>" and password as "<password>"
    #And click on login
    #Then page title should be "Dashboard / nopCommerce administration"
    #When user click on log out link
    #Then Page title should be "Your store.Login"
    #And Close Browser
    
    #Examples:
    #|email|password|
    #|admin@yourstore.com|admin|
    #|Test@yourstore.com|admin|