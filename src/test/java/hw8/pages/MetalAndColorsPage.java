package hw8.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MetalAndColorsPage extends WebPage {

    @FindBy(name = "custom_radio_odd")
    public static RadioButtons radioButtonsOdd;

    @FindBy(name = "custom_radio_even")
    public static RadioButtons radioButtonsEven;

    @Css("#elements-checklist label")
    public static JList<Label> elements;

    public static String titleMetalAndColorsPage = "Metal and Colors";

    @JDropdown(
            root = "div[ui='dropdown']",
            value = ".filter-option",
            list = "li",
            expand = ".caret")
    public static Dropdown colors;

    @JDropdown(
            root = "div[ui='combobox']",
            value = "input",
            list = "li",
            expand = ".caret")
    public static Dropdown metals;

    @FindBy(xpath = "//div[@id='vegetables']//li")
    public static JList<Label> vegetables;

    @FindBy(id = "vegetables")
    private static WebElement vegetableDropList;

    @FindBy(id = "submit-button")
    public static Button submitButton;

    @FindBy(xpath = "//ul[@class='panel-body-list results']//li")
    public static JList<Label> results;

    public static void clickElements(List<String> checkedElements) {
        for (Label element : elements) {
            if (checkedElements.contains(element.getText())) {
                element.click();
            }
        }
    }

    public static void clickVegetables(List<String> vegetable) {
        vegetableDropList.click();
        vegetables.list().get(3).click();
        for (WebElement element : vegetables.list()) {
            if (vegetable.contains(element.getText())) {
                element.click();
            }
        }
    }

    public static void checkSummary(List<String> data) {
        int expectedResult = Integer.parseInt(data.get(0)) + Integer.parseInt(data.get(1));
        int actualResult = Integer.parseInt(results.get(1).getText().substring(9));
        Assert.assertEquals(actualResult, expectedResult);
    }

    public static void checkColor(String expectedColor) {
        String actualColor = results.get(3).getText().substring(7);
        Assert.assertEquals(actualColor, expectedColor);
    }

    public static void checkMetal(String expectedMetal) {
        String actualMetal = results.get(4).getText().substring(7);
        Assert.assertEquals(actualMetal, expectedMetal);
    }

    public static void checkElements(List<String> expectedDataElements) {
        String elements = results.get(2).getText().substring(10).replaceAll(" ", "");
        String[] mass = elements.split(",");
        List<String> actualList = new ArrayList<>(Arrays.asList(mass));
        assertThat(actualList).containsExactlyInAnyOrderElementsOf(expectedDataElements);
    }

    public static void checkVegetables(List<String> expectedDataVegetable) {
        String elements = results.get(5).getText().substring(12).replaceAll(" ", "");
        String[] mass = elements.split(",");
        List<String> actualList = new ArrayList<>(Arrays.asList(mass));
        assertThat(actualList).containsExactlyInAnyOrderElementsOf(expectedDataVegetable);
    }

}
