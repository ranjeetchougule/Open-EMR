Feature: add new patient feature
Scenario: new register patient
Given user is already logged in with "Admin" and "Admin123"
When user click on register patient option
And user enter firstname as "jack"
And user enter lastname as "sparrow"
And user click on gender
And user select gender
And user click on birthday
And user select birthdate as day "02", month 03 and year "1999"
And user click on confirm