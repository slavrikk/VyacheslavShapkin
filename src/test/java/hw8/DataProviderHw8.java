package hw8;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import hw8.beans.MetalsAndColorsTestData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DataProviderHw8 {

   public static String absPath = new File("").getAbsolutePath() +
            "/src/test/resources/hw8/JDI_ex8_metalsColorsDataSet.json";

    @org.testng.annotations.DataProvider(name = "data")
    public static Object[][] dataProvider() throws FileNotFoundException {

        return getTestData()
                .stream()
                .map(data -> new MetalsAndColorsTestData[]{data})
                .toArray(Object[][]::new);
    }

    public static List<MetalsAndColorsTestData> getTestData() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonParser().parse(
                new FileReader(absPath)).getAsJsonObject();
        List<MetalsAndColorsTestData> gsonData = new ArrayList<>();
        for(String k : jsonObject.keySet()){
            gsonData.add(gson.fromJson(jsonObject.get(k), MetalsAndColorsTestData.class));
        }
        return gsonData;
    }
}