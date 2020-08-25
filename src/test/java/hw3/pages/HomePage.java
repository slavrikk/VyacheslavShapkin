package hw3.pages;

import hw3.pages.components.Footer;
import hw3.pages.components.HeaderMenu;
import hw3.pages.components.LeftMenu;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage {

    @FindBy(xpath = "//img[@id='user-icon']")
    private WebElement userIcon;
    @FindBy(xpath = "//input[@id='name']")
    private WebElement inputName;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;
    @FindBy(xpath = "//span[contains(text(),'Enter')]")
    private WebElement enter;
    @FindBy(xpath = "//span[@id='user-name']")
    private WebElement userName;
    @FindBy(xpath = "//h3[@name='main-title']")
    private WebElement mainHeader;
    @FindBy(xpath = "//p[@name='jdi-text']")
    private WebElement jdiHeader;
    @FindBy(xpath = "//iframe[@id='jdi-frame-site']")
    private WebElement iframe;
    @FindBy(xpath = "//img[@id='epam-logo']")
    private WebElement iframeEpamLogo;
    @FindBy(xpath = "//a[contains(text(),'JDI Github')]")
    private WebElement jdiElementLink;
    @FindBy(xpath = "//span[contains(@class,'icons-benefit')]")
    private List<WebElement> imagesList;
    @FindBy(xpath = "//span[contains(@class,'benefit-txt')]")
    private List<WebElement> listText;


    private final WebDriver driver;

    private final HeaderMenu headerMenu;
    private final LeftMenu leftMenu;
    private final Footer footer;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        headerMenu = new HeaderMenu(driver);
        leftMenu = new LeftMenu(driver);
        footer = new Footer(driver);
    }

    @Step("Open index page")
    public void open() {
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
    }

    @Step("Get title")
    public String getTitle() {
        return driver.getTitle();
    }

    @Step("Login on the site with parameters: login = {login}, password= {password}")
    public void login(String login, String password) {
        userIcon.click();
        inputName.sendKeys(login);
        inputPassword.sendKeys(password);
        enter.click();
    }

    @Step("Get user name")
    public String getUserName() {
        return userName.getText();
    }

    @Step("Get quantity header menu items")
    public int quantityHeaderMenu() {
        return headerMenu.getListHeaderItems().size();
    }

    @Step("Get header menu item by name - {name}")
    public String getTextHeaderMenuItem(String name) {
        String nameUp = name.toUpperCase();
        List<WebElement> webElements = headerMenu.getListHeaderItems();
        String findElement = "";
        for (WebElement webElement : webElements) {
            if (webElement.getText().equals(nameUp)) {
                findElement = webElement.getText();
                break;
            }
        }

        return findElement;
    }

    @Step("Quantity of images")
    public int quantityImages() {
        return imagesList.size();
    }


    @Step("Find out the text and image - {text}")
    public void findTextUnderImage(String expectedText) {


        String actualText = expectedText;
        String findElement = "";
        for (WebElement webElement : listText) {
            if (webElement.getText().equals(expectedText)) {
                findElement = webElement.getText();
                break;
            }

        }

        Assert.assertEquals(actualText, findElement);
    }

    @Step("Get service header menu item {service}")
    public String getTextServiceHeaderMenuItem(String service) {
        String serviceUp = service.toUpperCase();
        List<WebElement> webElements = headerMenu.getServicesElementList();
        String findElement = "";
        for (WebElement webElement : webElements) {
            if (webElement.getText().equals(serviceUp)) {
                findElement = webElement.getText();
                break;
            }
        }

        return findElement;
    }

    @Step("Get service left menu item - {service}")
    public String getTextServiceLeftMenuItem(String service) {

        List<WebElement> webElements = leftMenu.getListServices();
        String findElement = "";
        for (WebElement webElement : webElements) {
            if (webElement.getText().equals(service)) {
                findElement = webElement.getText();
                break;
            }
        }

        return findElement;
    }

    @Step("Click left service")
    public void clickLeftService() {
        leftMenu.getServiceButton().click();
    }

    @Step("Get main header")
    public String getMainHeader() {
        return mainHeader.getText();
    }

    @Step("Get Jdi Header")
    public String getJdiHeader() {
        return jdiHeader.getText();
    }

    @Step("Get Header Menu")
    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    @Step("Existing frame")
    public boolean frameIsEnable() {
        return iframe.isEnabled();
    }

    @Step("Existing logo")
    public boolean frameLogoIsEnable() {
        return iframeEpamLogo.isEnabled();
    }

    @Step("Get sub header text")
    public String getSubHeader() {
        return jdiElementLink.getText();
    }

    @Step("Get sub header link")
    public String getSubHeaderLink() {
        return jdiElementLink.getAttribute("href");
    }

    @Step("Existing menu")
    public boolean leftMenuIsEnable() {
        return leftMenu.getLeftBar().isEnabled();
    }

    @Step("Existing footer")
    public boolean footerIsEnable() {
        return footer.getFooterBar().isEnabled();
    }

    public LeftMenu getLeftMenu() {
        return leftMenu;
    }

    public Footer getFooter() {
        return footer;
    }

    public List<WebElement> getImagesList() {
        return imagesList;
    }

    public List<WebElement> getListText() {
        return listText;
    }

    @Step("Get Iframe")
    public WebElement getIframe() {
        return iframe;
    }

    @Step("Navigate to Different element page")
    public DifferentElementsPage navigateToDifferentElementsPage() {
        headerMenu.getServiceButton().click();
        headerMenu.getDifferentElementsButton().click();
        return new DifferentElementsPage(driver);
    }

    @Step("Click service header")
    public void clickServiceHeader() {
        headerMenu.getServiceButton().click();
    }

}
