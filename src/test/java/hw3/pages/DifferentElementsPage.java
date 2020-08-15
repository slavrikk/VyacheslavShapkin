package hw3.pages;

import hw3.pages.components.LeftMenu;
import hw3.pages.components.LogComponent;
import io.qameta.allure.Step;
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

    @Step("Obtain quantity check boxes")
    public int quantityCheckBoxes() {
        return listCheckboxes.size();
    }

    @Step("Obtain quantity buttons")
    public int quantityRadioButtons() {
        return listRadioButtons.size();
    }

    @Step("Existence Drop Down")
    public boolean dropDownEnable() {
        return dropDown.isEnabled();
    }

    @Step("Existence button")
    public boolean buttonEnable() {
        return button.isEnabled();
    }

    @Step("Existence default button")
    public boolean defaultButtonEnable() {
        return defaultButton.isEnabled();
    }

    @Step("Existence left section")
    public boolean leftSection() {

        return leftMenu.getLeftBar().isEnabled();
    }

    @Step("Existence right section")
    public boolean logRightSection() {
        return logComponent.getRightLogSidebar().isEnabled();
    }

    @Step("Click select Wind")
    public void selectWind() {
        windCheckBox.click();
    }

    @Step("Click select Water")
    public void selectWater() {
        waterCheckbox.click();
    }

    @Step("Get Water checkbox")
    public WebElement getWaterCheckbox() {
        return waterCheckbox;
    }

    @Step("Get Wind checkbox")
    public WebElement getWindCheckBox() {
        return windCheckBox;
    }

    @Step("Get Selen radio button")
    public WebElement getSelenRadioButton() {
        return selenRadioButton;
    }

    @Step("Get yellow Drop Down")
    public WebElement getYellowDropDown() {
        return yellowDropDown;
    }

    @Step("Get text Wind check log")
    public String textLogCheckWind() {
        return logComponent.getLogWind().getText().substring(9);
    }

    @Step("Get text Water check log")
    public String textLogCheckWater() {
        return logComponent.getLogWater().getText().substring(9);
    }

    @Step("Select Selen")
    public void selectSelen() {
        selenRadioButton.click();
    }

    @Step("Get text Selen check log")
    public String textLogCheckSelen() {
        return logComponent.getLogSelen().getText().substring(9);
    }

    @Step("Select yellow Drop Down")
    public void selectYellowDropDown() {
        dropDown.click();
        yellowDropDown.click();
    }

    @Step("Get text yellow check log")
    public String textLogCheckYellow() {
        return logComponent.getLogYellow().getText().substring(9);
    }

    @Step("Get text Wind uncheck log")
    public String textLogUncheckWind() {
        return logComponent.getLogUncheckWind().getText().substring(9);
    }

    @Step("Get text Water uncheck log")
    public String textLogUncheckWater() {
        return logComponent.getLogUncheckWater().getText().substring(9);
    }

    public LeftMenu getLeftMenu() {
        return leftMenu;
    }
}
