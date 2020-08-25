package hw4.ex1;

import hw3.AbstractTest;
import hw3.pages.HomePage;
import hw4.TestListener;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
@Feature("Features on the Home page")
@Story("Test Home page site without multi assertions")
public class TestStepPatternExOne extends AbstractTest {

    private HomePage homePage;


    @Test(priority = 1, description = "Test home page title")
    public void testHomePageTitle() {
        homePage = new HomePage(driver);
        homePage.open();
        String actualTitle = homePage.getTitle();
        String expectedTitle = "Home Page";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(priority = 2, description = "Test login name")
    public void testLoginName() {
        homePage.login(property.getProperty("username"), property.getProperty("password"));
        String actualName = homePage.getUserName();
        String expectedName = "ROMAN IOVLEV";
        Assert.assertEquals(actualName, expectedName);
    }

    @Test(priority = 3, description = "Test home page title one more")
    public void testHomePageTitleOneMore() {
        homePage = new HomePage(driver);
        homePage.open();
        String actualTitle = homePage.getTitle();
        String expectedTitle = "Home Page";
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(priority = 4, description = "Test quantity menu items")
    public void testQuantityMenuItems() {
        int actualQuantityItems = homePage.quantityHeaderMenu();
        int expectQuantityItems = 4;
        Assert.assertEquals(actualQuantityItems, expectQuantityItems);
    }

    @Test(priority = 5, description = "Test HOME header button")
    public void testHomeHeaderButton() {
        String actualButton = homePage.getTextHeaderMenuItem("HOME");
        String expectedButton = "HOME";
        Assert.assertEquals(actualButton, expectedButton);
    }

    @Test(priority = 6, description = "Test CONTACT FORM header button")
    public void testContactHeaderButton() {
        String actualButton = homePage.getTextHeaderMenuItem("CONTACT FORM");
        String expectedButton = "CONTACT FORM";
        Assert.assertEquals(actualButton, expectedButton);
    }

    @Test(priority = 7, description = "Test SERVICE header button")
    public void testServiceHeaderButton() {
        String actualButton = homePage.getTextHeaderMenuItem("SERVICE");
        String expectedButton = "SERVICE";
        Assert.assertEquals(actualButton, expectedButton);
    }

    @Test(priority = 8, description = "Test METALS & COLORS header button")
    public void testServiceMetalsButton() {
        String actualButton = homePage.getTextHeaderMenuItem("METALS & COLORS");
        String expectedButton = "METALS & COLORS";
        Assert.assertEquals(actualButton, expectedButton);
    }

    @Test(priority = 9, description = "Test quantity images")
    public void testQuantityImgItems() {

        int actualQuantityItems = homePage.quantityImages();
        int expectQuantityItems = 4;
        Assert.assertEquals(actualQuantityItems, expectQuantityItems);
    }

    @Test(priority = 10, description = "Test text under first image")
    public void testTextUnderImgOne() {

        String expectedText = "To include good practices\nand ideas from successful\nEPAM project";
        homePage.findTextUnderImage(expectedText);

    }

    @Test(priority = 11, description = "Test text under second image")
    public void testTextUnderImgTwo() {
        String expectedText = "To be flexible and\ncustomizable";
        homePage.findTextUnderImage(expectedText);

    }

    @Test(priority = 12, description = "Test text under third image")
    public void testTextUnderImgThree() {
        String expectedText = "To be multiplatform";
        homePage.findTextUnderImage(expectedText);

    }

    @Test(priority = 13,description = "Test text under fourth image")
    public void testTextUnderImgFour() {
        String expectedText =
                "Already have good base\n(about 20 internal and\n"
                        + "some external projects),\nwish to get more…";

        homePage.findTextUnderImage(expectedText);

    }

    @Test(priority = 14, description = "Test Main Header text")
    public void testMainHeaderText() {

        String actualText = homePage.getMainHeader();
        String expectedText = "EPAM FRAMEWORK WISHES…";
        Assert.assertEquals(actualText, expectedText);
    }

    @Test(priority = 15, description = "Test Jdi header text")
    public void testJdiHeaderText() {

        String actualText = homePage.getJdiHeader();
        String expectedText =
                "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, "
                        + "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. "
                        + "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS"
                        + " NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR"
                        + " IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU "
                        + "FUGIAT NULLA PARIATUR.";

        Assert.assertEquals(actualText, expectedText);
    }

    @Test(priority = 16, description = "Test Jdi frame existence")
    public void testJdiFrameExist() {
        boolean existedFrame = homePage.frameIsEnable();
        Assert.assertTrue(existedFrame);
    }

    @Test(priority = 17, description = "Test EPAM Logo on the frame existence")
    public void testJdiFrameEpamLogoExist() {

        driver.switchTo().frame(homePage.getIframe());

        boolean existedLogo = homePage.frameLogoIsEnable();
        Assert.assertTrue(existedLogo);
    }

    @Test(priority = 18, description = "Test JGI Hub Text")
    public void testJdiGitHubText() {
        driver.switchTo().defaultContent();

        String actualText = homePage.getSubHeader();
        String expectedText = "JDI GITHUB";

        Assert.assertEquals(actualText, expectedText);
    }

    @Test(priority = 19, description = "Test Jdi link text")
    public void testJdiGitHubLink() {


        String actualText = homePage.getSubHeaderLink();
        String expectedText = "https://github.com/epam/JDI";

        Assert.assertEquals(actualText, expectedText);
    }

    @Test(priority = 20, description = "Test existence left menu")
    public void testLeftSectionIsDisplayed() {

        boolean leftSectionIsExisted = homePage.leftMenuIsEnable();
        Assert.assertTrue(leftSectionIsExisted);
    }

    @Test(priority = 21, description = "Test existence footer")
    public void testFooterSectionIsDisplayed() {

        boolean footerSectionIsExisted = homePage.footerIsEnable();
        Assert.assertTrue(footerSectionIsExisted);
    }


}
