package hw8.pages.forms;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import hw8.entities.User;

public class LoginForm extends Form<User> {


    @FindBy(id = "name")
    public TextField name;
    @FindBy(id = "password")
    public TextField password;

    @FindBy(xpath = "//span[contains(text(),'Enter')]")
    public Button enter;
}
