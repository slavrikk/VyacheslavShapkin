package hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestExerciseOne {

  private WebDriver driver;

  // 0. Driver is launched via WebDriverManager
  @BeforeClass
  public void setupClass() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  /*
  1. Assert Browser title
  1.1 Open test site by URL and title is obtained and checked.
  */
  @Test(priority = 1)
  public void testHomePageTitle() {
    driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html ");
    String actualTitle = driver.getTitle();
    String expectedTitle = "Home Page";
    Assert.assertEquals(actualTitle, expectedTitle);
  }

  /*
  2. Assert User name
  Assert User name in the left-top side of screen that user is loggined
  */
  @Test(priority = 2)
  public void testLoginName() {

    WebElement icon = driver.findElement(By.id("user-icon"));
    icon.click();
    WebElement inputName = driver.findElement(By.id("name"));
    inputName.sendKeys("Roman");
    WebElement inputPassword = driver.findElement(By.xpath("//input[@id='password']"));
    inputPassword.sendKeys("Jdi1234");

    WebElement enter = driver.findElement(By.xpath("//span[contains(text(),'Enter')]"));
    enter.click();

    String actualUserName = driver.findElement(By.id("user-name")).getText();
    String expectedUserName = "ROMAN IOVLEV";
    Assert.assertEquals(actualUserName, expectedUserName);
  }

  /*
  3. Assert Browser title
  3.1 Title is obtained and checked
   */
  @Test(priority = 3)
  public void testHomePageTitleOneMore() {
    String actualTitle = driver.getTitle();
    String expectedTitle = "Home Page";
    Assert.assertEquals(actualTitle, expectedTitle);
  }

  /*
  4. Assert Menu Items
  Assert that there are 4 items on the header section are displayed
   */
  @Test(priority = 4)
  public void testQuantityMenuItems() {
    List<WebElement> webElementList =
        driver.findElements(By.xpath("//ul[contains(@class, 'm-l8')]/li"));
    int actualQuantityItems = webElementList.size();
    int expectQuantityItems = 4;
    Assert.assertEquals(actualQuantityItems, expectQuantityItems);
  }

  /*
  5-8 Assert that Menu buttons have proper texts
  5. Assert Home Text
  5.1 Menu Home text is obtained and checked
   */
  @Test(priority = 5)
  public void testHomeHeaderButton() {
    WebElement homeButton = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
    String actualButton = homeButton.getText();
    String expectedButton = "HOME";
    Assert.assertEquals(actualButton, expectedButton);
  }

  /*
  6. Assert Contact Form Text
  6.1 Contact Form text is obtained and checked
   */
  @Test(priority = 6)
  public void testContactHeaderButton() {
    WebElement contactButton = driver.findElement(By.xpath("//a[contains(text(),'Contact form')]"));
    String actualButton = contactButton.getText();
    String expectedButton = "CONTACT FORM";
    Assert.assertEquals(actualButton, expectedButton);
  }

  /*
  7. Assert Service Text
  7.1 Service text is obtained and checked
   */
  @Test(priority = 7)
  public void testServiceHeaderButton() {
    WebElement serviceButton = driver.findElement(By.xpath("//a[contains(text(),'Service')]"));
    String actualButton = serviceButton.getText();
    String expectedButton = "SERVICE";
    Assert.assertEquals(actualButton, expectedButton);
  }

  /*
  8. Assert Metals & Colors Text
  8.1 Metals & Colors text is obtained and checked
   */
  @Test(priority = 8)
  public void testServiceMetalsButton() {
    WebElement metalButton =
        driver.findElement(By.xpath("//a[contains(text(),'Metals & Colors')]"));
    String actualButton = metalButton.getText();
    String expectedButton = "METALS & COLORS";
    Assert.assertEquals(actualButton, expectedButton);
  }

  /*
  9. Assert quantity of images
  Assert that there are 4 images on the Index Page and they are displayed
   */
  @Test(priority = 9)
  public void testQuantityImgItems() {
    List<WebElement> webElementList =
        driver.findElements(By.xpath("//span[contains(@class,'icons-benefit')]"));
    int actualQuantityItems = webElementList.size();
    int expectQuantityItems = 4;
    Assert.assertEquals(actualQuantityItems, expectQuantityItems);
  }

  /*
  10-13. Assert that there are 4 texts on the Index Page under icons and they have proper text

  10. Assert text after the first image
  10.1 Text is obtained and checked
   */
  @Test(priority = 10)
  public void testTextUnderImgOne() {
    WebElement text =
        driver.findElement(By.xpath("//span[contains(@class,'icon-practise')]/following::span[1]"));
    String actualText = text.getText();
    String expectedText = "To include good practices\nand ideas from successful\nEPAM project";
    Assert.assertEquals(actualText, expectedText);
  }

  /*
  11. Assert text after the second image
  11.1 Text is obtained and checked
   */
  @Test(priority = 11)
  public void testTextUnderImgTwo() {
    WebElement text =
        driver.findElement(By.xpath("//span[contains(@class,'icon-custom')]/following::span[1]"));

    String actualText = text.getText();
    String expectedText = "To be flexible and\ncustomizable";
    Assert.assertEquals(actualText, expectedText);
  }

  /*
  12. Assert text after the third image
  12.1 Text is obtained and checked
   */
  @Test(priority = 12)
  public void testTextUnderImgThree() {

    WebElement text =
        driver.findElement(By.xpath("//span[contains(@class,'icon-multi')]/following::span[1]"));

    String actualText = text.getText();

    String expectedText = "To be multiplatform";
    Assert.assertEquals(actualText, expectedText);
  }

  /*
  13. Assert text after the fourth image
  13.1 Text is obtained and checked
   */
  @Test(priority = 13)
  public void testTextUnderImgFour() {

    WebElement text =
        driver.findElement(By.xpath("//span[contains(@class,'icon-base')]/following::span[1]"));

    String actualText = text.getText();

    String expectedText =
        "Already have good base\n(about 20 internal and\n"
            + "some external projects),\nwish to get more…";
    Assert.assertEquals(actualText, expectedText);
  }

  /*
  14. Assert main header text
  Assert a text of the main headers
   */
  @Test(priority = 14)
  public void testMainHeaderText() {
    WebElement text = driver.findElement(By.xpath("//h3[@name='main-title']"));
    String actualText = text.getText();
    String expectedText = "EPAM FRAMEWORK WISHES…";
    Assert.assertEquals(actualText, expectedText);
  }

  /*
  15. Assert Jdi header text
  15.1 Text is obtained and checked
   */
  @Test(priority = 15)
  public void testJdiHeaderText() {
    WebElement text = driver.findElement(By.xpath("//p[@name='jdi-text']"));
    String actualText = text.getText();
    String expectedText =
        "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, "
            + "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. "
            + "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS"
            + " NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR"
            + " IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU "
            + "FUGIAT NULLA PARIATUR.";

    Assert.assertEquals(actualText, expectedText);
  }

  /*
  16. Assert iframe existence
  Assert that there is the iframe in the center of page
   */
  @Test(priority = 16)
  public void testJdiFrameExist() {
    WebElement frame = driver.findElement(By.id("jdi-frame-site"));
    boolean existedFrame = frame.isEnabled();
    Assert.assertTrue(existedFrame);
  }

  /*
  17. Assert logo existence within the iframe
  Switch to the iframe and check that there is Epam logo in the left top conner of iframe
   */
  @Test(priority = 17)
  public void testJdiFrameEpamLogoExist() {
    WebElement frame = driver.findElement(By.id("jdi-frame-site"));
    driver.switchTo().frame(frame);
    WebElement epamLogo = driver.findElement(By.id("epam-logo"));
    boolean existedLogo = epamLogo.isEnabled();
    Assert.assertTrue(existedLogo);
  }

  /*
  18. Assert Jdi Git Hub text
  Assert a text of the sub header
  18.1 Driver is turned back to the page
  18.2 Text is obtained and checked
   */
  @Test(priority = 18)
  public void testJdiGitHubText() {
    driver.switchTo().defaultContent();

    WebElement jdiHeader = driver.findElement(By.xpath("//a[contains(text(),'JDI Github')]"));

    String actualText = jdiHeader.getText();
    String expectedText = "JDI GITHUB";

    Assert.assertEquals(actualText, expectedText);
  }

  /*
  19. Assert Jdi Git Hub link
  Assert that JDI GITHUB is a link and has a proper URL
  */
  @Test(priority = 19)
  public void testJdiGitHubLink() {

    WebElement jdiHeaderLink = driver.findElement(By.xpath("//a[contains(text(),'JDI Github')]"));

    String actualText = jdiHeaderLink.getAttribute("href");
    String expectedText = "https://github.com/epam/JDI";

    Assert.assertEquals(actualText, expectedText);
  }

  /*
  20. Assert Left Section existence
  Assert that there is Left Section
  */
  @Test(priority = 20)
  public void testLeftSectionIsDisplayed() {
    WebElement leftSection = driver.findElement(By.xpath("//div[@name='navigation-sidebar']"));
    boolean leftSectionIsExisted = leftSection.isEnabled();
    Assert.assertTrue(leftSectionIsExisted);
  }

  /*
  21. Assert Footer Section existence
 Assert that there is Footer
  */
  @Test(priority = 21)
  public void testFooterSectionIsDisplayed() {
    WebElement footerSection = driver.findElement(By.xpath("//div[@class='footer-bg']"));
    boolean footerSectionIsExisted = footerSection.isEnabled();
    Assert.assertTrue(footerSectionIsExisted);
  }

  // Close Browser
  @AfterClass
  public void teardown() {
    if (driver != null) {
      driver.quit();
    }
  }
}
