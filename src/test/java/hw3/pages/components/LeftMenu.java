package hw3.pages.components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LeftMenu {

    @FindBy(xpath = "//ul[@class='sidebar-menu']")
    private WebElement leftBar;
    @FindBy(xpath = "//span[contains(text(),'Service')]")
    private WebElement serviceButton;

    @FindBy(xpath = "//ul[@class='sub']/li")
    private List<WebElement> listServices;

    private WebDriver driver;

    public LeftMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step("Get left bar")
    public WebElement getLeftBar() {
        return leftBar;
    }

    @Step("Get list services")
    public List<WebElement> getListServices() {
        return listServices;
    }

    @Step("Get service button")
    public WebElement getServiceButton() {
        return serviceButton;
    }
}
