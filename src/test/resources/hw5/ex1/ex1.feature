Feature: Elements on the Different Elements Page are checked and Log text is approved
  In order to check elements
  As a user
  I want to login and navigate to Different Elements Page

  Scenario:
    Given I open Home Page
    Then Browser title should be equal "Home Page"
    Given I login as user Roman Iovlev login 'Roman' password 'Jdi1234'
    Then Name should be displayed and equals to expected username "ROMAN IOVLEV"
    Given I open Different Elements Page through Service  header menu
    When Select checkboxes Water and Wind
    And Select radiobutton Selen
    And Select drop down to Yellow
    Then Log rows are displayed and checkbox name and its status are corresponding to selected
    And Log rows are displayed and radio button name and it status is corresponding to selected
    And Log rows are displayed and dropdown name and selected value is corresponding to selected
