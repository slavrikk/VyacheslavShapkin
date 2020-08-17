package hw5.tests;

import hw5.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@CucumberOptions(features="src/test/resources/hw5/ex1")
public class RunAcceptanceEx1 extends AbstractTestNGCucumberTests {

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        TestContext.getInstance().setDriver(driver);
    }

    @After
    public void tearDown() {

        TestContext.getInstance().getDriver().quit();
    }
}
