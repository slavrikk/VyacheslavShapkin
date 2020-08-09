package hw3.pages;

import hw3.pages.components.LeftMenu;
import hw3.pages.components.LogComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DifferentElementsPage {

    @FindBy(xpath = "//label[contains(@class,'label-checkbox')]")
    private List<WebElement> listCheckboxes;
    @FindBy(xpath = "//label[contains(@class,'label-radio')]")
    private List<WebElement> listRadioButtons;

    @FindBy(xpath = "//select[@class='uui-form-element']")
    private WebElement dropDown;
    @FindBy(xpath = "//button[@name='Default Button']")
    private WebElement defaultButton;
    @FindBy(xpath = "//input[@class='uui-button']")
    private WebElement button;
    @FindBy(xpath = "//label[contains(@class,'label-checkbox')][1]/input")
    private WebElement waterCheckbox;
    @FindBy(xpath = "//label[contains(@class,'label-checkbox')][3]/input")
    private WebElement windCheckBox;
    @FindBy(xpath = "//label[contains(@class,'label-radio')][4]/input[1]")
    private WebElement selenRadioButton;
    @FindBy(xpath = "//option[contains(text(),'Yellow')]")
    private WebElement yellowDropDown;


    private final LogComponent logComponent;
    private final LeftMenu leftMenu;

    public DifferentElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        logComponent = new LogComponent(driver);
        leftMenu = new LeftMenu(driver);
    }

    public int quantityCheckBoxes() {
        return listCheckboxes.size();
    }

    public int quantityRadioButtons() {
        return listRadioButtons.size();
    }

    public boolean dropDownEnable() {
        return dropDown.isEnabled();
    }

    public boolean buttonEnable() {
        return button.isEnabled();
    }

    public boolean defaultButtonEnable() {
        return defaultButton.isEnabled();
    }

    public boolean leftSection() {

        return leftMenu.getLeftBar().isEnabled();
    }

    public boolean logRightSection() {
        return logComponent.getRightLogSidebar().isEnabled();
    }

    public void selectWind() {
        windCheckBox.click();
    }

    public void selectWater() {
        waterCheckbox.click();
    }

    public WebElement getWaterCheckbox() {
        return waterCheckbox;
    }

    public WebElement getWindCheckBox() {
        return windCheckBox;
    }

    public WebElement getSelenRadioButton() {
        return selenRadioButton;
    }

    public WebElement getYellowDropDown() {
        return yellowDropDown;
    }

    public String textLogCheckWind() {
        return logComponent.getLogWind().getText().substring(9);
    }

    public String textLogCheckWater() {
        return logComponent.getLogWater().getText().substring(9);
    }

    public void selectSelen() {
        selenRadioButton.click();
    }

    public String textLogCheckSelen() {
        return logComponent.getLogSelen().getText().substring(9);
    }

    public void selectYellowDropDown() {
        dropDown.click();
        yellowDropDown.click();
    }

    public String textLogCheckYellow() {
        return logComponent.getLogYellow().getText().substring(9);
    }

    public String textLogUncheckWind() {
        return logComponent.getLogUncheckWind().getText().substring(9);
    }

    public String textLogUncheckWater() {
        return logComponent.getLogUncheckWater().getText().substring(9);
    }

    public LeftMenu getLeftMenu() {
        return leftMenu;
    }
}
