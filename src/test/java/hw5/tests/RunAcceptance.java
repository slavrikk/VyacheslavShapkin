package hw5.tests;

import hw5.context.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@CucumberOptions(features= {
        "src/test/resources/hw5/ex1",
        "src/test/resources/hw5/ex2",
        "src/test/resources/hw5/ex3"})
public class RunAcceptance extends AbstractTestNGCucumberTests {


    @Before
    public void setUp()  {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        TestContext.getInstance().setDriver(driver);

    }

    @After
    public void tearDown() {

        TestContext.getInstance().getDriver().quit();
    }
}
