package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSqrtDouble {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "sqrt-double")
    public void testSqrtDouble(double a, double expectedResult){
        Calculator calculator = new Calculator();
        double actualResult = calculator.sqrt(a);
        Assert.assertEquals(actualResult, expectedResult, 0.05);
    }
}
