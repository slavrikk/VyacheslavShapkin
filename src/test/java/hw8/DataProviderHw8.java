package hw8;

import com.google.gson.Gson;
import hw8.beans.DataBean;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DataProviderHw8 {

    @org.testng.annotations.DataProvider(name = "data")
    public static Object[][] dataProvider() throws FileNotFoundException {
        String absPath = new File("").getAbsolutePath() +
                "/src/test/resources/hw8/JDI_ex8_metalsColorsDataSet.json";
        Gson gson = new Gson();
        DataBean dataBean = gson.fromJson(new FileReader(new File(absPath)), DataBean.class);
        return new Object[][]{
                {dataBean.getData_1()},
                {dataBean.getData_2()},
                {dataBean.getData_3()},
                {dataBean.getData_4()},
                {dataBean.getData_5()}};
    }

}