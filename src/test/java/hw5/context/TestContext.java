package hw5.context;

import org.openqa.selenium.WebDriver;

public class TestContext {

    private static TestContext instance;

    private WebDriver driver;

    private TestContext() {
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }


}
