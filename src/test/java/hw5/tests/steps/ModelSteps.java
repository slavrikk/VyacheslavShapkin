package hw5.tests.steps;

import hw3.pages.HomePage;
import hw5.context.TestContext;
import io.cucumber.java.en.Given;

public class ModelSteps {

    private final HomePage homePage =
            new HomePage(TestContext.getInstance().getDriver());

    @Given("I open Home Page")
    public void i_open_Home_Page() {
       homePage.open();
    }

    @Given("I open Different Elements Page through Service  header menu")
    public void i_open_Different_Elements_Page_through_Service_header_menu() {
        homePage.navigateToDifferentElementsPage();
    }

    @Given("I login as user {string}")
    public void i_login_as_user(String string) {

        homePage.login("Roman", "Jdi1234");
    }

}
