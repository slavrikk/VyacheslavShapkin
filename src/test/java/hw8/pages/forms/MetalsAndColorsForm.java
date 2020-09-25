package hw8.pages.forms;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import hw8.beans.MetalsAndColorsTestData;
import org.openqa.selenium.WebElement;


public class MetalsAndColorsForm extends Form<MetalsAndColorsTestData> {

    @FindBy(name = "custom_radio_odd")
    public static RadioButtons radioButtonsOdd;

    @FindBy(name = "custom_radio_even")
    public static RadioButtons radioButtonsEven;

    @Css("#elements-checklist label")
    public static JList<Label> elements;

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

    public static void unCheckVegetable(){
        vegetableDropList.click();
        vegetables.list().get(3).click();
    }

    @Override
    public void submit(MetalsAndColorsTestData entity) {

        radioButtonsOdd.select(entity.getSummary().get(0));
        radioButtonsEven.select(entity.getSummary().get(1));

        for (Label element : elements) {
            if (entity.getElements().contains(element.getText())) {
                element.click();
            }
        }
        colors.select(entity.getColor());
        metals.select(entity.getMetals());
        unCheckVegetable();
        for (WebElement element : vegetables.list()) {
            if (entity.getVegetables().contains(element.getText())) {
                element.click();
            }
        }
        submitButton.click();
    }
}
