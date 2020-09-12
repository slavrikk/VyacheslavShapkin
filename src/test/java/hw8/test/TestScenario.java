package hw8.test;

import hw8.DataProviderHw8;
import hw8.JdiSite;
import hw8.beans.MetalsAndColorsTestData;
import org.testng.Assert;
import org.testng.annotations.Test;

import static hw8.JdiSite.*;
import static hw8.entities.User.ROMAN;
import static hw8.pages.MetalAndColorsPage.*;

public class TestScenario implements TestInit {


    @org.testng.annotations.Test
    public void loginTest() {
        open();
        login(ROMAN);
        jdiHomePage.checkUserLoggedIn(ROMAN);
    }

    @Test
    public void openMetalAndColorsPage() {
        jdiHomePage.openMetalsAndColorsPage();
        Assert.assertEquals(getTitle(), titleMetalAndColorsPage);
    }

    @org.testng.annotations.Test(dataProviderClass = DataProviderHw8.class, dataProvider = "data")
    public void scenariosTest(MetalsAndColorsTestData entity) {

       metalsAndColorsForm.submit(entity);

       verifyResults(entity.expectedResult());

        JdiSite.openMetalAndColorsPage();
    }
}
