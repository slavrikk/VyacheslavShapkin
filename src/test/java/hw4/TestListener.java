package hw4;

import hw3.AbstractTest;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

  private static String getTestMethodName(ITestResult iTestResult) {
    return iTestResult.getMethod().getConstructorOrMethod().getName();
  }

  @Attachment(value = "Page screenshot", type = "image/png")
  public byte[] saveScreenShotPNG(WebDriver driver) {
    return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
  }

  @Override
  public void onTestFailure(ITestResult result) {
    System.out.println("I am in onTestFailure method " + getTestMethodName(result) + " failed");

    // Get driver from BaseTest and assign to local webdriver variable.
    Object testClass = result.getInstance();
    WebDriver driver = ((AbstractTest) testClass).getDriver();

    // Allure ScreenShotRobot and SaveTestLog
    if (driver instanceof WebDriver) {
      System.out.println("Screenshot captured for test case:" + getTestMethodName(result));
      saveScreenShotPNG(driver);
    }
  }
}
