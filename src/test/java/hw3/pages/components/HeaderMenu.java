package hw3.pages.components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HeaderMenu {

    @FindBy(xpath = "//ul[contains(@class, 'm-l8')]/li")
    private List<WebElement> listHeaderItems;
    @FindBy(xpath = "//ul[@class='dropdown-menu']/li")
    private List<WebElement> servicesElementList;
    @FindBy(xpath = "//a[contains(text(),'Service')]")
    private WebElement serviceButton;
    @FindBy(xpath = "//a[contains(text(),'Different elements')]")
    private WebElement differentElementsButton;


    private WebDriver driver;

    public HeaderMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step("Get list header items")
    public List<WebElement> getListHeaderItems() {
        return listHeaderItems;
    }

    @Step("Get service button")
    public WebElement getServiceButton() {
        return serviceButton;
    }

    @Step("Get different elements button")
    public WebElement getDifferentElementsButton() {
        return differentElementsButton;
    }

    @Step("Get service element list")
    public List<WebElement> getServicesElementList() {
        return servicesElementList;
    }
}
