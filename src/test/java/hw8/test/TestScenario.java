package hw8.test;

import hw8.DataProviderHw8;
import hw8.beans.ExampleData;
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
    public void scenariosTest(ExampleData exampleData) throws InterruptedException {

        radioButtonsOdd.select(exampleData.getSummary().get(0));
        radioButtonsEven.select(exampleData.getSummary().get(1));
        clickElements(exampleData.getElements());
        colors.select(exampleData.getColor());
        metals.select(exampleData.getMetals());
        clickVegetables(exampleData.getVegetables());

        submitButton.click();

        checkSummary(exampleData.getSummary());
        checkElements(exampleData.getElements());
        checkColor(exampleData.getColor());
        checkMetal(exampleData.getMetals());
        checkVegetables(exampleData.getVegetables());

        clickVegetables(exampleData.getVegetables());
        clickElements(exampleData.getElements());

    }
}
