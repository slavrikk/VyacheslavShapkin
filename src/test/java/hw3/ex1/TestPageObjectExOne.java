package hw3.ex1;

import hw3.AbstractTest;
import hw3.pages.BasePage;
import hw3.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPageObjectExOne extends AbstractTest {
  private BasePage basePage = new BasePage();
  private HomePage homePage;

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
    String expectedName = "ROMAN IOVLEV";
    basePage.compareStrings(homePage.getUserName(), expectedName);
  }

  @Test(priority = 3)
  public void testHomePageTitleOneMore() {
    homePage = new HomePage(driver);
    homePage.open();
    String expectedTitle = "Home Page";
    basePage.compareStrings(homePage.getTitle(), expectedTitle);
  }

  @Test(priority = 4)
  public void testQuantityMenuItems() {
    int expectQuantityItems = 4;
    basePage.compareQuantity(homePage.quantityHeaderMenu(), expectQuantityItems);
  }

  @Test(priority = 5)
  public void testHomeHeaderButton() {
    String expectedButton = "HOME";
    basePage.compareStrings(homePage.getTextHeaderMenuItem("HOME"), expectedButton);
  }

  @Test(priority = 6)
  public void testContactHeaderButton() {
    String expectedButton = "CONTACT FORM";
    basePage.compareStrings(homePage.getTextHeaderMenuItem("CONTACT FORM"), expectedButton);
  }

  @Test(priority = 7)
  public void testServiceHeaderButton() {
    String expectedButton = "SERVICE";
    basePage.compareStrings(homePage.getTextHeaderMenuItem("SERVICE"), expectedButton);
  }

  @Test(priority = 8)
  public void testServiceMetalsButton() {
    String expectedButton = "METALS & COLORS";
    basePage.compareStrings(homePage.getTextHeaderMenuItem("METALS & COLORS"), expectedButton);
  }

  @Test(priority = 9)
  public void testQuantityImgItems() {
    int expectQuantityItems = 4;
    basePage.compareQuantity(homePage.quantityImages(), expectQuantityItems);
  }

  @Test(priority = 10)
  public void testTextUnderImgOne() {

    String expectedText = "To include good practices\nand ideas from successful\nEPAM project";
    homePage.findTextUnderImage(expectedText);
  }

  @Test(priority = 11)
  public void testTextUnderImgTwo() {
    String expectedText = "To be flexible and\ncustomizable";
    homePage.findTextUnderImage(expectedText);
  }

  @Test(priority = 12)
  public void testTextUnderImgThree() {
    String expectedText = "To be multiplatform";
    homePage.findTextUnderImage(expectedText);
  }

  @Test(priority = 13)
  public void testTextUnderImgFour() {
    String expectedText =
        "Already have good base\n(about 20 internal and\n"
            + "some external projects),\nwish to get more…";

    homePage.findTextUnderImage(expectedText);
  }

  @Test(priority = 14)
  public void testMainHeaderText() {

    String actualText = homePage.getMainHeader();
    String expectedText = "EPAM FRAMEWORK WISHES…";
    Assert.assertEquals(actualText, expectedText);
  }

  @Test(priority = 15)
  public void testJdiHeaderText() {

    String expectedText =
        "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, "
            + "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. "
            + "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS"
            + " NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR"
            + " IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU "
            + "FUGIAT NULLA PARIATUR.";

    basePage.compareStrings(homePage.getJdiHeader(), expectedText);
  }

  @Test(priority = 16)
  public void testJdiFrameExist() {
    boolean existedFrame = homePage.frameIsEnable();
    Assert.assertTrue(existedFrame);
  }

  @Test(priority = 17)
  public void testJdiFrameEpamLogoExist() {

    driver.switchTo().frame(homePage.getIframe());

    boolean existedLogo = homePage.frameLogoIsEnable();
    Assert.assertTrue(existedLogo);
  }

  @Test(priority = 18)
  public void testJdiGitHubText() {
    driver.switchTo().defaultContent();
    String expectedText = "JDI GITHUB";
    basePage.compareStrings(homePage.getSubHeader(), expectedText);
  }

  @Test(priority = 19)
  public void testJdiGitHubLink() {
    String expectedText = "https://github.com/epam/JDI";
    basePage.compareStrings(homePage.getSubHeaderLink(), expectedText);
  }

  @Test(priority = 20)
  public void testLeftSectionIsDisplayed() {

    boolean leftSectionIsExisted = homePage.leftMenuIsEnable();
    Assert.assertTrue(leftSectionIsExisted);
  }

  @Test(priority = 21)
  public void testFooterSectionIsDisplayed() {

    boolean footerSectionIsExisted = homePage.footerIsEnable();
    Assert.assertTrue(footerSectionIsExisted);
  }
}
