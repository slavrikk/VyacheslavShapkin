package hw8.test;

import hw8.DataProviderHw8;
import hw8.JdiSite;
import hw8.beans.MetalsAndColorsTestData;
import static hw8.pages.MetalAndColorsPage.*;

public class TestScenario extends BeforeTestSteps {


    @org.testng.annotations.Test(dataProviderClass = DataProviderHw8.class, dataProvider = "data")
    public void scenariosTest(MetalsAndColorsTestData entity) {

       metalsAndColorsForm.submit(entity);

       verifyResults(entity.expectedResult());

        JdiSite.openMetalAndColorsPage();
    }
}
