package hw8.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import hw8.pages.forms.MetalsAndColorsForm;



import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MetalAndColorsPage extends WebPage {

    public static String titleMetalAndColorsPage = "Metal and Colors";

    @FindBy(xpath = "//form[@class='form']")
    public static MetalsAndColorsForm metalsAndColorsForm;


    @FindBy(xpath = "//ul[@class='panel-body-list results']//li")
    public static JList<Label> results;


    public static List<String> actualResult(){
        List<String> actualResult = new ArrayList<>();
        for(Label res:results){
           actualResult.add(res.getText());
        }
        return actualResult;
    }

    public static void verifyResults(List<String> expectedResult){
        assertThat(actualResult()).containsExactlyInAnyOrderElementsOf(expectedResult);
    }



}
