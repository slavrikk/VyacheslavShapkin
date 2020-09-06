package hw8.pages.header;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;

public class HeaderHomePage extends Section {

    @FindBy(xpath = "//ul[contains(@class, 'm-l8')]/li")
    public WebList menu;

}
