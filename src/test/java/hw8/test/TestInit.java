package hw8.test;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.driver.WebDriverUtils;
import hw8.JdiSite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.light.elements.init.PageFactory.initSite;

public interface TestInit {
    final String pathToDriver = "src\\test\\resources\\driver\\chromedriver.exe";

    public static WebDriver getMyDriver() {
        System.setProperty("webdriver.chrome.driver", pathToDriver);
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        return webDriver;
    }

    @BeforeSuite(alwaysRun = true)
    public static void setUp() {
        WebDriverFactory.useDriver("my_driver", TestInit::getMyDriver);
        initSite(JdiSite.class);
    }

    @AfterSuite
    public static void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

}
