package hw8;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import hw8.entities.User;
import hw8.pages.JdiHomePage;
import hw8.pages.MetalAndColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("index.html")
    public static JdiHomePage jdiHomePage;

    @Url("metals-colors.html")
    public static MetalAndColorsPage metalAndColorsPage;

    public static void open() {
        jdiHomePage.open();
    }

    public static void login(User user) {
        jdiHomePage.login(user);
    }

}
