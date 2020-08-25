package hw3.ex2;

import hw3.AbstractTest;
import hw3.pages.BasePage;
import hw3.pages.DifferentElementsPage;
import hw3.pages.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestPageObjectExTwo extends AbstractTest {

  private HomePage homePage;
  private DifferentElementsPage differentElementsPage;
  private BasePage basePage = new BasePage();

  @Test(priority = 1)
  public void testHomePageTitle() {
    homePage = new HomePage(driver);
    homePage.open();
    String expectedTitle = "Home Page";
    basePage.compareStrings(homePage.getTitle(), expectedTitle);
  }

  @Test(priority = 2)
  public void testLoginName() {

    homePage.login(property.getProperty("username"), property.getProperty("password"));
    String expectedUserName = "ROMAN IOVLEV";
    basePage.compareStrings(homePage.getUserName(), expectedUserName);
  }

  @Test(priority = 3)
  public void testServiceHeaderDropDownOptions() {

    homePage.clickServiceHeader();

    String actualSupport = homePage.getTextServiceHeaderMenuItem("SUPPORT");
    String actualDates = homePage.getTextServiceHeaderMenuItem("DATES");
    String actualComplexTable = homePage.getTextServiceHeaderMenuItem("COMPLEX TABLE");
    String actualSimpleTable = homePage.getTextServiceHeaderMenuItem("SIMPLE TABLE");
    String actualTablePages = homePage.getTextServiceHeaderMenuItem("TABLE WITH PAGES");
    String actualDifferentElement = homePage.getTextServiceHeaderMenuItem("DIFFERENT ELEMENTS");

    SoftAssert softAssert = new SoftAssert();

    softAssert.assertEquals(actualSupport, "SUPPORT");
    softAssert.assertEquals(actualDates, "DATES");
    softAssert.assertEquals(actualComplexTable, "COMPLEX TABLE");
    softAssert.assertEquals(actualSimpleTable, "SIMPLE TABLE");
    softAssert.assertEquals(actualTablePages, "TABLE WITH PAGES");
    softAssert.assertEquals(actualDifferentElement, "DIFFERENT ELEMENTS");
    softAssert.assertAll();
  }

  @Test(priority = 4)
  public void testServiceLeftSectionOption() {

    homePage.clickLeftService();

    String actualSupportText = homePage.getTextServiceLeftMenuItem("Support");
    String actualDatesText = homePage.getTextServiceLeftMenuItem("Dates");
    String actualComplexTableText = homePage.getTextServiceLeftMenuItem("Complex Table");
    String actualSimpleTableText = homePage.getTextServiceLeftMenuItem("Simple Table");
    String actualTableWithPageText = homePage.getTextServiceLeftMenuItem("Table with pages");
    String actualDifferentElements = homePage.getTextServiceLeftMenuItem("Different elements");

    SoftAssert softAssert = new SoftAssert();

    softAssert.assertEquals(actualSupportText, "Support");
    softAssert.assertEquals(actualDatesText, "Dates");
    softAssert.assertEquals(actualComplexTableText, "Complex Table");
    softAssert.assertEquals(actualSimpleTableText, "Simple Table");
    softAssert.assertEquals(actualTableWithPageText, "Table with pages");
    softAssert.assertEquals(actualDifferentElements, "Different elements");
    softAssert.assertAll();
  }

  @Test(priority = 5)
  public void testInterfaceOnDifferentPage() {

    differentElementsPage = homePage.navigateToDifferentElementsPage();

    int quantityCheckBoxes = differentElementsPage.quantityCheckBoxes();
    int quantityRadioButtons = differentElementsPage.quantityRadioButtons();

    SoftAssert softAssert = new SoftAssert();

    softAssert.assertEquals(quantityCheckBoxes, 4);
    softAssert.assertEquals(quantityRadioButtons, 4);
    softAssert.assertTrue(differentElementsPage.dropDownEnable());
    softAssert.assertTrue(differentElementsPage.buttonEnable());
    softAssert.assertTrue(differentElementsPage.defaultButtonEnable());
    softAssert.assertAll();
  }

  @Test(priority = 6)
  public void testSections() {

    SoftAssert softAssert = new SoftAssert();

    softAssert.assertTrue(differentElementsPage.leftSection());
    softAssert.assertTrue(differentElementsPage.logRightSection());
    softAssert.assertAll();
  }

  @Test(priority = 7)
  public void testSelectAndLogsCheckBoxes() {

    differentElementsPage.selectWater();
    differentElementsPage.selectWind();
    boolean waterSelect = differentElementsPage.getWaterCheckbox().isSelected();
    boolean windSelect = differentElementsPage.getWindCheckBox().isSelected();
    String logTextWater = differentElementsPage.textLogCheckWater();
    String logTextWind = differentElementsPage.textLogCheckWind();

    SoftAssert softAssert = new SoftAssert();

    softAssert.assertTrue(waterSelect);
    softAssert.assertTrue(windSelect);
    softAssert.assertEquals(logTextWater, "Water: condition changed to true");
    softAssert.assertEquals(logTextWind, "Wind: condition changed to true");
    softAssert.assertAll();
  }

  @Test(priority = 8)
  public void testSelectRadioButtonAndLog() {

    differentElementsPage.selectSelen();
    String logText = differentElementsPage.textLogCheckSelen();
    boolean selenButton = differentElementsPage.getSelenRadioButton().isSelected();

    SoftAssert softAssert = new SoftAssert();

    softAssert.assertTrue(selenButton);
    softAssert.assertEquals(logText, "metal: value changed to Selen");
    softAssert.assertAll();
  }

  @Test(priority = 9)
  public void testSelectDropDownAndLog() {

    differentElementsPage.selectYellowDropDown();
    boolean dropYellowSelect = differentElementsPage.getYellowDropDown().isEnabled();
    String logYellow = differentElementsPage.textLogCheckYellow();

    SoftAssert softAssert = new SoftAssert();

    softAssert.assertTrue(dropYellowSelect);
    softAssert.assertEquals(logYellow, "Colors: value changed to Yellow");
    softAssert.assertAll();
  }

  @Test(priority = 10)
  public void testUncheckBoxesLog() {
    differentElementsPage.selectWind();
    differentElementsPage.selectWater();
    boolean waterCheckBox = differentElementsPage.getWaterCheckbox().isSelected();
    boolean windCheckBox = differentElementsPage.getWindCheckBox().isSelected();
    String logTextWater = differentElementsPage.textLogUncheckWater();
    String logTextWind = differentElementsPage.textLogUncheckWind();

    SoftAssert softAssert = new SoftAssert();

    softAssert.assertFalse(waterCheckBox);
    softAssert.assertFalse(windCheckBox);
    softAssert.assertEquals(logTextWater, "Water: condition changed to false");
    softAssert.assertEquals(logTextWind, "Wind: condition changed to false");
    softAssert.assertAll();
  }
}
