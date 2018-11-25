Feature: login feature to login in to site

  Scenario: Login as a authenticated user
    Given user is on homepage
    When user navigates to Login Page
    And user enters username and Password
    Then success message is displayed

  Scenario: Purchase Free Ebook
    Given user is on homepage
    When user search for free ebook
    When user selects a free ebook
    And user enters username and Password
    Then TYP for free ebook

  Scenario: Add Ebook to list
    Given user is on homepage
    When login first
    And user enters username and Password
    When user add ebooks to new list
    Then Verify 2 books in list

  Scenario: Get sample for ebook
    Given user is on homepage
    When login first
    And user enters username and Password
    When user search for ebook
    When user get sample
    Then TYP for free ebook

  Scenario: Delete list
    Given user is on homepage
    When login first
    And user enters username and Password
    When user delete list
    Then Verify no list