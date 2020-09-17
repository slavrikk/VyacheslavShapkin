package hw8.test;

import org.testng.annotations.BeforeClass;

import static hw8.JdiSite.*;
import static hw8.entities.User.ROMAN;

public class BeforeTestSteps implements TestInit{

    @BeforeClass
    public void preConditionSteps(){
        open();
        login(ROMAN);
        jdiHomePage.openMetalsAndColorsPage();
    }
}
