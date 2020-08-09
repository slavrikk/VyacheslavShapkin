package hw3.pages.components;

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

    public WebElement getRightLogSidebar() {
        return rightLogSidebar;
    }

    public WebElement getLogWater() {
        return logWater;
    }

    public WebElement getLogWind() {
        return logWind;
    }

    public WebElement getLogSelen() {
        return logSelen;
    }

    public WebElement getLogYellow() {
        return logYellow;
    }

    public WebElement getLogUncheckWater() {
        return logUncheckWater;
    }

    public WebElement getLogUncheckWind() {
        return logUncheckWind;
    }
}
