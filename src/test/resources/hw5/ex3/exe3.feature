Feature:
  Scenario:

    Given I open Home Page
    And I login as user Roman Iovlev login 'Roman' password 'Jdi1234'
    And I click on Service button in Header
    And I click on "User Table" button in Service dropdown
    When I select vip checkbox for Sergey Ivan
    Then One log row has "Vip: condition changed to true" text in log section




