Feature: Job Finder Test
  Scenario Outline: Verify that a particular job and it's readme link exists in the website
    Given Open Dave.com
    And Navigate to the Careers page
    And Verify that particular job opening "<jobs>" exists in the career page
    When I click on Login button
    Then I should be able to successfully login

    Examples:
      |jobs     |
      |Senior QA Engineer|