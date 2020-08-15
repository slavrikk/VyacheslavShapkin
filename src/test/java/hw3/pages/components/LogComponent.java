package hw3.pages.components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogComponent {

    @FindBy(xpath = "//div[@name='log-sidebar']")
    private WebElement rightLogSidebar;
    @FindBy(xpath = "//li[contains(text(),'Water: condition changed to true')]")
    private WebElement logWater;
    @FindBy(xpath = "//li[contains(text(),'Wind: condition changed to true')]")
    private WebElement logWind;
    @FindBy(xpath = "//li[contains(text(),'Selen')]")
    private WebElement logSelen;
    @FindBy(xpath = "//li[contains(text(),'Colors: value changed to Yellow')]")
    private WebElement logYellow;
    @FindBy(xpath = "//li[contains(text(),'Water: condition changed to false')]")
    private WebElement logUncheckWater;
    @FindBy(xpath = "//li[contains(text(),'Wind: condition changed to false')]")
    private WebElement logUncheckWind;


    private WebDriver driver;

    public LogComponent(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step("Get right log Side bar")
    public WebElement getRightLogSidebar() {
        return rightLogSidebar;
    }

    @Step("Get Log Water text")
    public WebElement getLogWater() {
        return logWater;
    }

    @Step("Get log Wind text")
    public WebElement getLogWind() {
        return logWind;
    }

    @Step("Get log Selen text")
    public WebElement getLogSelen() {
        return logSelen;
    }

    @Step("Get log yellow text")
    public WebElement getLogYellow() {
        return logYellow;
    }

    @Step("Get log uncheck Water text")
    public WebElement getLogUncheckWater() {
        return logUncheckWater;
    }

    @Step("Get log uncheck Wind text")
    public WebElement getLogUncheckWind() {
        return logUncheckWind;
    }
}
