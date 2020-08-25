package hw4;

import hw3.AbstractTest;
import hw3.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class TestFailed extends AbstractTest {

    private HomePage homePage;

    @Test(priority = 1, description = "Test home page title")
    public void testHomePageTitle() {
        homePage = new HomePage(driver);
        homePage.open();
        String actualTitle = homePage.getTitle();
        String expectedTitle = "Home Pag";
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
