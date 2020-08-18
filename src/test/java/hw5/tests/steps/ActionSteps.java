package hw5.tests.steps;

import hw3.pages.DifferentElementsPage;
import hw3.pages.HomePage;
import hw5.context.TestContext;
import hw5.context.UserTablePage;
import io.cucumber.java.en.When;

public class ActionSteps {

    private final HomePage homePage =
            new HomePage(TestContext.getInstance().getDriver());
    private final DifferentElementsPage differentElementsPage =
            new DifferentElementsPage(TestContext.getInstance().getDriver());
    private final UserTablePage userTablePage =
            new UserTablePage(TestContext.getInstance().getDriver());


    @When("Select checkboxes Water and Wind")
    public void select_checkboxes_Water_and_Wind() {
        differentElementsPage.selectWind();
        differentElementsPage.selectWater();
    }

    @When("Select radiobutton Selen")
    public void select_radiobutton_Selen() {
        differentElementsPage.selectSelen();
    }

    @When("Select drop down to Yellow")
    public void select_drop_down_to_Yellow() {
        differentElementsPage.selectYellowDropDown();
    }

    @When("I click on Service button in Header")
    public void i_click_on_button_in_Header() {
        homePage.clickServiceHeader();
    }

    @When("I click on {string} button in Service dropdown")
    public void i_click_on_button_in_Service_dropdown(String dropDownItem) {
        homePage.getServiceHeaderMenuItem(dropDownItem).click();
    }

    @When("I select vip checkbox for Sergey Ivan")
    public void i_select_checkbox_for() {
        userTablePage.getCheckboxIvan().click();
    }

}
