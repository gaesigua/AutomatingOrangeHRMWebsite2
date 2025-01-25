@LoginFeature @Regression
Feature: OrangeHRM Login Functionality

@Scenario1 @Smoke
Scenario: User should not be able to login with invalid credentials
Given User is on the OrangeHRM login page
When  User enters username as "Admin1"
When  User enters password as "admin1234" 
And  User clicks on the submit button
Then  User should not land on the Dashboard page

@Scenario2 @Smoke
Scenario: User should not be able to login with invalid credentials
Given User is on the OrangeHRM login page
When  User enters username as "Admin2"
When  User enters password as "admin123456" 
When  User clicks on the submit button
Then  User should not land on the Dashboard page

@Scenario2 @Smoke
Scenario: User should be able to login with valid credentials
Given User is on the OrangeHRM login page
When  User enters username as "Admin"
When  User enters password as "admin123" 
And  User clicks on the submit button
Then  User should land on the Dashboard page