package hw2.ex2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestExerciseTwo {

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

    String actualUserName = driver.findElement(By.xpath("//span[@id='user-name']")).getText();
    String expectedUserName = "ROMAN IOVLEV";
    Assert.assertEquals(actualUserName, expectedUserName);
  }

  /*
  Assert that in the header drop down contains options : Support, Dates,
  Complex Table, Simple Table, Tables With Pages, Different Elements
   */
  @Test(priority = 3)
  public void testServiceHeaderDropDownOptions() {

    WebElement service = driver.findElement(By.xpath("//a[contains(text(),'Service')]"));

    service.click();

    String actualSupportText =
        driver.findElement(By.xpath("//a[contains(text(),'Support')]")).getText();
    String actualDatesText =
        driver.findElement(By.xpath("//a[contains(text(),'Dates')]")).getText();
    String actualComplexTableText =
        driver.findElement(By.xpath("//a[contains(text(),'Complex Table')]")).getText();
    String actualSimpleTableText =
        driver.findElement(By.xpath("//a[contains(text(),'Simple Table')]")).getText();
    String actualTableWithPageText =
        driver.findElement(By.xpath("//a[contains(text(),'Table with pages')]")).getText();
    String actualDifferentElementsText =
        driver.findElement(By.xpath("//a[contains(text(),'Different elements')]")).getText();

    SoftAssert softAssert = new SoftAssert();
    softAssert.assertEquals(actualSupportText, "SUPPORT");
    softAssert.assertEquals(actualDatesText, "DATES");
    softAssert.assertEquals(actualComplexTableText, "COMPLEX TABLE");
    softAssert.assertEquals(actualSimpleTableText, "SIMPLE TABLE");
    softAssert.assertEquals(actualTableWithPageText, "TABLE WITH PAGES");
    softAssert.assertEquals(actualDifferentElementsText, "DIFFERENT ELEMENTS");
    softAssert.assertAll();
  }

  /*
  Assert that in the left section drop down contains options : Support, Dates,
  Complex Table, Simple Table, Tables With Pages, Different Elements
   */
  @Test(priority = 4)
  public void testServiceLeftSectionOption() {

    WebElement service = driver.findElement(By.xpath("//span[contains(text(),'Service')]"));

    service.click();

    String actualSupportText =
        driver.findElement(By.xpath("//span[contains(text(),'Support')]")).getText();
    String actualDatesText =
        driver.findElement(By.xpath("//span[contains(text(),'Dates')]")).getText();
    String actualComplexTableText =
        driver.findElement(By.xpath("//span[contains(text(),'Complex Table')]")).getText();
    String actualSimpleTableText =
        driver.findElement(By.xpath("//span[contains(text(),'Simple Table')]")).getText();
    String actualTableWithPageText =
        driver.findElement(By.xpath("//span[contains(text(),'Table with pages')]")).getText();
    String actualDifferentElementsText =
        driver.findElement(By.xpath("//span[contains(text(),'Different elements')]")).getText();

    SoftAssert softAssert = new SoftAssert();
    softAssert.assertEquals(actualSupportText, "Support");
    softAssert.assertEquals(actualDatesText, "Dates");
    softAssert.assertEquals(actualComplexTableText, "Complex Table");
    softAssert.assertEquals(actualSimpleTableText, "Simple Table");
    softAssert.assertEquals(actualTableWithPageText, "Table with pages");
    softAssert.assertEquals(actualDifferentElementsText, "Different elements");
    softAssert.assertAll();
  }

  /*
  Assert that 4 checkboxes, 4 radios, 1 dropdown, 2 buttons are existed on the
  Different elements page
   */
  @Test(priority = 5)
  public void testInterfaceOnDifferentPage() {
    WebElement service = driver.findElement(By.xpath("//a[contains(text(),'Service')]"));
    service.click();
    WebElement differentElement =
        driver.findElement(By.xpath("//a[contains(text(),'Different elements')]"));
    differentElement.click();
    List<WebElement> listCheckBoxes =
        driver.findElements(By.xpath("//label[contains(@class,'label-checkbox')]"));
    List<WebElement> listRadioButtons =
        driver.findElements(By.xpath("//label[contains(@class,'label-radio')]"));
    WebElement dropDown = driver.findElement(By.xpath("//select[@class='uui-form-element']"));
    WebElement firstButton = driver.findElement(By.xpath("//button[@name='Default Button']"));
    WebElement secondButton = driver.findElement(By.xpath("//input[@class='uui-button']"));

    SoftAssert softAssert = new SoftAssert();

    softAssert.assertEquals(listCheckBoxes.size(), 4);
    softAssert.assertEquals(listRadioButtons.size(), 4);
    softAssert.assertTrue(dropDown.isEnabled());
    softAssert.assertTrue(firstButton.isEnabled());
    softAssert.assertTrue(secondButton.isEnabled());
    softAssert.assertAll();
  }

  /*
  Assert that Right Section and Left Section are on the Different elements page
   */
  @Test(priority = 6)
  public void testSections() {
    WebElement leftSection = driver.findElement(By.xpath("//div[@name='navigation-sidebar']"));
    WebElement rightSection = driver.findElement(By.xpath("//div[@name='log-sidebar']"));
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertTrue(leftSection.isEnabled());
    softAssert.assertTrue(rightSection.isEnabled());
    softAssert.assertAll();
  }

  /*
  Assert that Water and Wind checkboxes are checked individual log row and value is corresponded
  to the status of checkbox.
   */
  @Test(priority = 7)
  public void testSelectAndLogsCheckBoxes() {
    WebElement waterCheckBox =
        driver.findElement(By.xpath("//label[contains(@class,'label-checkbox')][1]/input"));
    WebElement windCheckBox =
        driver.findElement(By.xpath("//label[contains(@class,'label-checkbox')][3]/input"));
    waterCheckBox.click();
    windCheckBox.click();

    String logTextWater =
        driver
            .findElement(By.xpath("//li[contains(text(),'Water: condition changed to true')]"))
            .getText();
    String logTextWind =
        driver
            .findElement(By.xpath("//li[contains(text(),'Wind: condition changed to true')]"))
            .getText();

    SoftAssert softAssert = new SoftAssert();

    softAssert.assertTrue(waterCheckBox.isSelected());
    softAssert.assertTrue(windCheckBox.isSelected());
    softAssert.assertEquals(logTextWater.substring(9), "Water: condition changed to true");
    softAssert.assertEquals(logTextWind.substring(9), "Wind: condition changed to true");
    softAssert.assertAll();
  }

  /*
  Assert that radio button is checked and for radiobutton there is a log row and value
  is corresponded to the status of radiobutton.
   */
  @Test(priority = 8)
  public void testSelectRadioButtonAndLog() {
    WebElement radioButton =
        driver.findElement(By.xpath("//label[contains(@class,'label-radio')][4]/input[1]"));
    radioButton.click();
    String logText = driver.findElement(By.xpath("//li[contains(text(),'Selen')]")).getText();

    SoftAssert softAssert = new SoftAssert();
    softAssert.assertTrue(radioButton.isSelected());
    softAssert.assertEquals(logText.substring(9), "metal: value changed to Selen");
    softAssert.assertAll();
  }

  /*
  Assert that dropdown is selected and for dropdown there is a log row and value
  is corresponded to the selected value.
   */
  @Test(priority = 9)
  public void testSelectDropDownAndLog() {
    WebElement drop = driver.findElement(By.xpath("//select[@class='uui-form-element']"));
    drop.click();
    WebElement dropYellow = driver.findElement(By.xpath("//option[contains(text(),'Yellow')]"));
    dropYellow.click();
    String logText =
        driver
            .findElement(By.xpath("//li[contains(text(),'Colors: value changed to Yellow')]"))
            .getText();
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertTrue(dropYellow.isSelected());
    softAssert.assertEquals(logText.substring(9), "Colors: value changed to Yellow");
    softAssert.assertAll();
  }

  /*
  Assert that Water and Wind checkboxes are unselected and for each checkbox there is
  an individual log row and value is corresponded to the status of checkbox.
   */
  @Test(priority = 10)
  public void testUncheckBoxesLog() {
    WebElement waterCheckBox =
        driver.findElement(By.xpath("//label[contains(@class,'label-checkbox')][1]/input"));
    WebElement windCheckBox =
        driver.findElement(By.xpath("//label[contains(@class,'label-checkbox')][3]/input"));
    waterCheckBox.click();
    windCheckBox.click();

    String logTextWater =
        driver
            .findElement(By.xpath("//li[contains(text(),'Water: condition changed to false')]"))
            .getText();
    String logTextWind =
        driver
            .findElement(By.xpath("//li[contains(text(),'Wind: condition changed to false')]"))
            .getText();

    SoftAssert softAssert = new SoftAssert();

    softAssert.assertFalse(waterCheckBox.isSelected());
    softAssert.assertFalse(windCheckBox.isSelected());
    softAssert.assertEquals(logTextWater.substring(9), "Water: condition changed to false");
    softAssert.assertEquals(logTextWind.substring(9), "Wind: condition changed to false");
    softAssert.assertAll();
  }

  // Close Browser
  @AfterClass
  public void teardown() {
    if (driver != null) {
      driver.quit();
    }
  }
}
