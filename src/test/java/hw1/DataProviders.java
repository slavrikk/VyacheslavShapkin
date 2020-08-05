package hw1;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "sum-double")
    public static Object[][] dataProviderMethodSumDouble() {
        return new Object[][]{{10.5, 10.5, 21.0}, {50.5, 50.5, 101.0}, {96.5621, 98.4221, 194.9842}};
    }

    @DataProvider(name = "sub-double")
    public static Object[][] dataProviderMethodSubDouble() {
        return new Object[][]{{13.53, 5.12, 8.41}, {56.789874, 25.98744555, 30.8024}, {96.5621, 98.4221, -1.86}};
    }

    @DataProvider(name = "multi-long")
    public static Object[][] dataProviderMethodMultiLong() {
        return new Object[][]{{5566L, 868L, 4831288L}, {98742L, -985214L, -97282000788L}, {12345679L, 9L, 111111111L}};
    }

    @DataProvider(name = "div-double")
    public static Object[][] dataProviderMethodDivDouble() {
        return new Object[][]{{13, 3, 4.333}, {123123123, 1001001, 123}, {57, -7, -8.142}};
    }

    @DataProvider(name = "sqrt-double")
    public static Object[][] dataProviderMethodSqrtDouble() {
        return new Object[][]{{13, 3.6}, {-59, 7.68}, {100, 10}};
    }
}
