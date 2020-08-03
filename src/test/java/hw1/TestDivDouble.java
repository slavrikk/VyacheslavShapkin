package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDivDouble {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "div-double")
    public void testDivDouble(double a, double b, double expectedResult){
        Calculator calculator = new Calculator();
        double actualResult = calculator.div(a,b);
        Assert.assertEquals(actualResult, expectedResult, 0.05);
    }
}
