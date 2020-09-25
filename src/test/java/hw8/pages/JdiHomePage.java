package hw8.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import hw8.entities.User;
import hw8.pages.forms.LoginForm;
import hw8.pages.header.HeaderHomePage;

public class JdiHomePage extends WebPage {

    @FindBy(id = "user-name")
    public Label userName;

    @FindBy(id = "user-icon")
    public Icon userIcon;


    public LoginForm loginForm;
    public HeaderHomePage headerHomePage;


    public void login(User user) {
        userIcon.click();
        loginForm.login(user);
    }

    public String getUserName() {
        return userName.getText();
    }

    public void openMetalsAndColorsPage() {
        headerHomePage.menu.get(4).click();

    }

    public void checkUserLoggedIn(User user) {
        userName.is().text(user.getFullName());
    }

}
