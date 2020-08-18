package hw5.context;

import hw3.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class UserTablePage {

    @FindBy(xpath = "//select")
    private List<WebElement> dropDowns;

    @FindBy(xpath = "//td/a")
    private List<WebElement> userNames;

    @FindBy(xpath = "//div[@class='user-descr']/span")
    private List<WebElement> descriptions;

    @FindBy(xpath = "//div[@class='user-descr']/input")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//tr[2]//option")
    private List<WebElement> optionsTypeForUserRoman;

    @FindBy(xpath = "//td[1]")
    private List<WebElement> numberColumn;

    @FindBy(xpath = "//tr[2]//select")
    private WebElement dropDownForRoman;

    @FindBy(xpath = "//li[contains(text(),'Vip: condition changed to true')]")
    private WebElement logVip;

    @FindBy(id = "ivan")
    private WebElement checkboxIvan;

    private final WebDriver driver;

    private final HomePage homePage =
            new HomePage(TestContext.getInstance().getDriver());


    public UserTablePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getUserName(String name) {
        String findElement = "";
        for (WebElement userName : userNames) {
            if (userName.getText().equals(name)) {
                findElement = userName.getText();
                break;
            }
        }

        return findElement;
    }

    public String getDescription(String name) {
        String findElement = "";
        for (WebElement description : descriptions) {
            if (description.getText().equals(name)) {
                findElement = description.getText();
                break;
            }
        }

        return findElement;
    }

    public List<WebElement> getDropDowns() {
        return dropDowns;
    }

    public List<WebElement> getUserNames() {
        return userNames;
    }

    public List<WebElement> getDescriptions() {
        return descriptions;
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<WebElement> getOptionsTypeForUserRoman() {
        return optionsTypeForUserRoman;
    }

    public List<String> getUserStringNames() {
        List<String> userNameStrings = new ArrayList<>();
        for (WebElement username : userNames) {
            userNameStrings.add(username.getText());
        }
        return userNameStrings;
    }

    public List<String> getUserStringNumbers() {
        List<String> numberColumnStrings = new ArrayList<>();
        for (WebElement number : numberColumn) {
            numberColumnStrings.add(number.getText());
        }
        return numberColumnStrings;
    }

    public List<String> getUserStringDescriptions() {
        List<String> descriptionStrings = new ArrayList<>();
        for (WebElement description : descriptions) {
            descriptionStrings.add(description.getText());
        }
        return descriptionStrings;
    }

    public WebElement getDropDownForRoman() {
        return dropDownForRoman;
    }

    public List<String> getOptionsStringForRoman() {
        List<String> optionStrings = new ArrayList<>();
        for (WebElement option : optionsTypeForUserRoman) {
            optionStrings.add(option.getText());
        }
        return optionStrings;
    }

    public WebElement getCheckboxIvan() {
        return checkboxIvan;
    }

    public WebElement getLogVip() {
        return logVip;
    }


}
