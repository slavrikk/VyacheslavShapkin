package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSumDouble {


    @Test(dataProviderClass = DataProviders.class, dataProvider = "sum-double")
    public void testSumDoubleFunctionality(double a, double b, double expectedResult) {
        Calculator calculator = new Calculator();
        double actualResult = calculator.sum(a, b);
        Assert.assertEquals(actualResult, expectedResult, 0.1);
    }
}
