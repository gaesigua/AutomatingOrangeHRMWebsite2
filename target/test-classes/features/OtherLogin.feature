@OtherLoginFeature @Regression
Feature: OrangeHRM Other Login Functionality

Background:
Given User is on the OrangeHRM login page

@Scenario1OfOtherLogin
Scenario Outline: User should not be able to login with invalid credentials
When  User enters username as "<username>"
When  User enters password as "<password>" 
And  User clicks on the submit button
Then  User should not land on the Dashboard page

Examples:
|username|password|
|admin2|admin123|
|admin3|admin123|