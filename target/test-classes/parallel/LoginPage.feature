Feature: login functinality
Scenario: login to registration desk
Given user is on the login page
When user enters the username "Admin"
And user enters the password "Admin123"
And user click on registration desk
And user click on log in button
Then user should land on home page