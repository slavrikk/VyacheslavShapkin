package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMultiLong {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "multi-long")
    public void testMultiDouble(long a, long b, long expectedResult) {
        Calculator calculator = new Calculator();
        long actualResult = calculator.mult(a, b);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
