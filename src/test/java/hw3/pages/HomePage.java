package hw3.pages;

import hw3.pages.components.Footer;
import hw3.pages.components.HeaderMenu;
import hw3.pages.components.LeftMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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


    public void open() {
        driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void login(String login, String password) {
        userIcon.click();
        inputName.sendKeys(login);
        inputPassword.sendKeys(password);
        enter.click();
    }

    public String getUserName() {
        return userName.getText();
    }

    public int quantityHeaderMenu() {
        return headerMenu.getListHeaderItems().size();
    }

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


    public int quantityImages() {
        return imagesList.size();
    }

    public String findTextUnderImage(String text) {

        String findElement = "";
        for (WebElement webElement : listText) {
            if (webElement.getText().equals(text)) {
                findElement = webElement.getText();
                break;
            }

        }

        return findElement;
    }

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

    public void clickLeftService() {
        leftMenu.getServiceButton().click();
    }

    public String getMainHeader() {
        return mainHeader.getText();
    }


    public String getJdiHeader() {
        return jdiHeader.getText();
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public boolean frameIsEnable() {
        return iframe.isEnabled();
    }

    public boolean frameLogoIsEnable() {
        return iframeEpamLogo.isEnabled();
    }

    public String getSubHeader() {
        return jdiElementLink.getText();
    }

    public String getSubHeaderLink() {
        return jdiElementLink.getAttribute("href");
    }

    public boolean leftMenuIsEnable() {
        return leftMenu.getLeftBar().isEnabled();
    }

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

    public WebElement getIframe() {
        return iframe;
    }

    public DifferentElementsPage navigateToDifferentElementsPage() {
        headerMenu.getServiceButton().click();
        headerMenu.getDifferentElementsButton().click();
        return new DifferentElementsPage(driver);
    }

    public void clickServiceHeader() {
        headerMenu.getServiceButton().click();
    }

}
