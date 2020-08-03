package hw1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSubDouble {

    @Test(dataProviderClass = DataProviders.class, dataProvider = "sub-double")
     public void testSubDouble(double a, double b, double expectedResult){
        Calculator calculator = new Calculator();
        double actualResult = calculator.sub(a, b);
        Assert.assertEquals(actualResult, expectedResult, 0.01);
}
}
