Feature: Job Finder Test
  Scenario Outline: Verify that a particular job and it's readme link exists in the website
    Given Open Dave.com
    And Navigate to the Careers page
    And Verify that particular job opening "<jobs>" exists in the career page
    When I click the Read More link for the particular job
    Then It opens up a new window containing the job description for the particular job

    Examples:
      |jobs     |
      |VP, Strategic Finance and Investor Relations|