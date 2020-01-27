@IntegrationTest
Feature: Get all the users
  mvn
  Scenario:
     When endpoint '/users' has been called
     Then the users should be as follows
      | id  | name   | departmentName                   | collegeName | age |
      | S01 | Akash  | Electronics & Telecommunications | Oist        | 29  |
      | S02 | Piyush | Information Technology           | Bist        | 30  |
