package hw3.pages;

import org.testng.Assert;

public class BasePage {

  public void compareStrings(String actual, String expected) {
    Assert.assertEquals(actual, expected);
  }

  public void compareQuantity(int actual, int expected) {
    Assert.assertEquals(actual, expected);
  }
}
