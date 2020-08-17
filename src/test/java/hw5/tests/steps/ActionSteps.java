package hw5.tests.steps;

import hw3.pages.DifferentElementsPage;
import hw3.pages.HomePage;
import hw5.context.TestContext;
import hw5.context.UserTablePage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ActionSteps {

    private final HomePage homePage =
            new HomePage(TestContext.getInstance().getDriver());
    private final DifferentElementsPage differentElementsPage =
            new DifferentElementsPage(TestContext.getInstance().getDriver());
    private final UserTablePage userTablePage =
            new UserTablePage(TestContext.getInstance().getDriver());

    @When("I login on the Home Page")
    public void i_login_on_the_Home_Page() {
        homePage.login("Roman", "Jdi1234");
    }

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

    @When("I click on {string} button in Header")
    public void i_click_on_button_in_Header(String string) {
        homePage.clickServiceHeader();

    }

    @When("I click on {string} button in Service dropdown")
    public void i_click_on_button_in_Service_dropdown(String string) {

        String upString = string.toUpperCase();
        List<WebElement> webElements = homePage.getHeaderMenu().getServicesElementList();
        WebElement findWebElement = null;
        for (WebElement webElement : webElements) {
            if (webElement.getText().equals(upString)) {
                findWebElement = webElement;
                break;
            }
        }
        if (findWebElement != null) {
            findWebElement.click();
        }
    }

    @When("I select {string} checkbox for {string}")
    public void i_select_checkbox_for(String string, String string2) {
        userTablePage.getCheckboxRoman().click();
    }

}
