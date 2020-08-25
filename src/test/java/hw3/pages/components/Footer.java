package hw3.pages.components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Footer {
    @FindBy(xpath = "//div[@class='footer-bg']")
    private WebElement footerBar;

    private WebDriver driver;

    public Footer(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @Step("Get footer")
    public WebElement getFooterBar() {
        return footerBar;
    }
}
