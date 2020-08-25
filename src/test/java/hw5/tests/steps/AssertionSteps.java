package hw5.tests.steps;

import hw3.pages.DifferentElementsPage;
import hw3.pages.HomePage;
import hw5.context.TestContext;
import hw5.context.UserTablePage;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AssertionSteps {

    private final HomePage homePage =
            new HomePage(TestContext.getInstance().getDriver());
    private final DifferentElementsPage differentElementsPage =
            new DifferentElementsPage(TestContext.getInstance().getDriver());

    private final UserTablePage userTablePage =
            new UserTablePage(TestContext.getInstance().getDriver());

    @Then("Browser title should be equal {string}")
    public void browser_title_should_be_equal(String homePageTitle) {
        String actualTitle = homePage.getTitle();
        Assert.assertEquals(actualTitle, homePageTitle);

    }

    @Then("Name should be displayed and equals to expected username {string}")
    public void name_should_be_displayed_and_equals_to_expected_username(String userName) {
        String actualName = homePage.getUserName();
        Assert.assertEquals(actualName, userName);
    }

    @Then("Log rows are displayed and checkbox name and its status are corresponding to selected")
    public void log_rows_are_displayed_and_checkbox_name_and_its_status_are_corresponding_to_selected() {
        differentElementsPage.textLogCheckWater();

        differentElementsPage.textLogCheckWind();
    }

    @Then("Log rows are displayed and radio button name and it status is corresponding to selected")
    public void log_rows_are_displayed_and_radio_button_name_and_it_status_is_corresponding_to_selected() {
        differentElementsPage.textLogCheckSelen();
    }

    @Then("Log rows are displayed and dropdown name and selected value is corresponding to selected")
    public void log_rows_are_displayed_and_dropdown_name_and_selected_value_is_corresponding_to_selected() {
        differentElementsPage.textLogCheckYellow();
    }

    @Then("{string} page should be opened")
    public void page_should_be_opened(String userTable) {
        String actualResult = userTablePage.getTitle();
        Assert.assertEquals(actualResult, userTable);
    }

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void number_Type_Dropdowns_should_be_displayed_on_Users_Table_on_User_Table_Page(Integer quantityDropDowns) {

        Integer actualResult = userTablePage.getDropDowns().size();
        Assert.assertEquals(actualResult, quantityDropDowns);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernames_should_be_displayed_on_Users_Table_on_User_Table_Page(Integer quantityUserNames) {
        Integer actualResult = userTablePage.getUserNames().size();
        Assert.assertEquals(actualResult, quantityUserNames);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void description_texts_under_images_should_be_displayed_on_Users_Table_on_User_Table_Page(Integer quantityDescriptions) {
        Integer actualResult = userTablePage.getDescriptions().size();
        Assert.assertEquals(actualResult, quantityDescriptions);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxes_should_be_displayed_on_Users_Table_on_User_Table_Page(Integer quantityCheckboxes) {
        Integer actualResult = userTablePage.getCheckboxes().size();
        Assert.assertEquals(actualResult, quantityCheckboxes);
    }

    @Test
    @Then("User table should contain following values:")
    public void user_table_should_contain_following_values(io.cucumber.datatable.DataTable usersInfoTable) {
        List<List<String>> list = usersInfoTable.asLists(String.class);
        List<String> userNumbersExpected = new ArrayList<>();
        List<String> userNamesExpected = new ArrayList<>();
        List<String> userDescriptionsExpected = new ArrayList<>();
        for (int i = 1; i < list.size(); i++) {
            userNumbersExpected.add(list.get(i).get(0));
            userNamesExpected.add(list.get(i).get(1));
            userDescriptionsExpected.add(list.get(i).get(2));
        }
        Assert.assertEquals(userNamesExpected, userTablePage.getUserStringNames());
        Assert.assertEquals(userNumbersExpected, userTablePage.getUserStringNumbers());
        Assert.assertEquals(userDescriptionsExpected, userTablePage.getUserStringDescriptions());

    }

    @Then("droplist should contain values in column Type for user Roman")
    public void droplist_should_contain_values_in_column_Type_for_user_Roman(io.cucumber.datatable.DataTable dropListTable) {
        userTablePage.getOptionsTypeForUserRoman().get(0).click();
        List<String> optionExpected = dropListTable.asList();
        List<String> optionWithoutHead = new ArrayList<>();
        optionExpected.remove("0");
        for (int i = 1; i < optionExpected.size(); i++) {
            optionWithoutHead.add(optionExpected.get(i));
        }
        List<String> actualResult = userTablePage.getOptionsStringForRoman();
        Assert.assertEquals(actualResult, optionWithoutHead);
    }

    @Then("One log row has {string} text in log section")
    public void log_row_has_text_in_log_section(String expectedText) {
        String actualText = userTablePage.getLogVip().getText().substring(9);
        Assert.assertEquals(actualText, expectedText);
    }

}
