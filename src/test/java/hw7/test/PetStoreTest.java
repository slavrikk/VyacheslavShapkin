package hw7.test;

import hw7.bean.PetBean;
import hw7.bean.ResponseBean;
import io.restassured.http.Method;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static hw7.core.PetStorePetServiceObj.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class PetStoreTest {

    private static final String randomName = RandomStringUtils.randomAlphabetic(10);
    private static final String randomCategoryName = RandomStringUtils.randomAlphabetic(10);
    private static final int randomCategoryId = Integer.parseInt(RandomStringUtils.randomNumeric(3,5));
    private static final int randomId = Integer.parseInt(RandomStringUtils.randomNumeric(2,7));
    private static final String randomNameNew = RandomStringUtils.randomAlphabetic(10);
    private static final String randomNewStatus = RandomStringUtils.randomAlphabetic(10);

     @BeforeClass
      public void randomValues(){

    System.out.println("Random values:");
    System.out.println("Random name: "+ randomName);
    System.out.println("Random category name: "+randomCategoryName);
    System.out.println("Random category id: "+randomCategoryId);
    System.out.println("Random id: "+randomId);
    System.out.println("Random new name: "+randomNameNew);
    System.out.println("Random new status: "+randomNewStatus);
     }


    @Test(priority = 1)
    public void postPetTest() {
        PetBean result = getAnswers(
                requestBuilder()
                        .setName(randomName)
                        .setId(randomId)
                        .setCategory(randomCategoryId, randomCategoryName)
                        .setTeg(randomId, randomName)
                        .setMethod(Method.POST)
                        .buildRequest()
                        .sendRequest());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(result.getId(), randomId);
        softAssert.assertEquals(result.getCategoryBean().getName(), randomCategoryName);
        softAssert.assertEquals(result.getTags().get(0).getId(), randomId);
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void getPetByIdTest() {
        PetBean result = getAnswers(
                requestBuilder()
                        .setMethod(Method.GET)
                        .buildRequest()
                        .sendRequestById(String.valueOf(randomId)));
        Assert.assertEquals(result.getName(), randomName);
        Assert.assertEquals(result.getCategoryBean().getId(),randomCategoryId);
    }


    @Test(priority = 3)
    public void changePetNameByIdTest() {
        ResponseBean result = getAnswersStatus(
                requestBuilder()
                        .setMethod(Method.POST)
                        .setContentType("URLENC")
                        .setId(randomId)
                        .setName(randomNameNew)
                        .setStatus(randomNewStatus)
                        .buildRequest()
                        .sendRequest());
        assertThat("API reported errors in type text: " + result.getMessage(), result.getMessage().equals((String.valueOf(randomId))));
    }


    @Test(priority = 4)
    public void checkChangePetStatusById() {
        PetBean result = getAnswers(
                requestBuilder()
                        .setMethod(Method.GET)
                        .buildRequest()
                        .sendRequestById(String.valueOf(randomId)));
        assertThat("API reported errors in type text: " + result.getStatus(), result.getStatus().equals(randomNewStatus));
    }

    @Test(priority = 4)
    public void deletePet() {
        ResponseBean result = getAnswersStatus(
                requestBuilder()
                        .setMethod(Method.DELETE)
                        .buildRequest()
                        .sendRequestById(String.valueOf(randomId)));
        assertThat("API reported errors in " + result.getCode(), result.getCode() == 200);

        ResponseBean checkResult = getAnswersStatus(
                requestBuilder()
                        .setMethod(Method.GET)
                        .buildRequest()
                        .sendRequestById(String.valueOf(randomId)));
        assertThat("API reported errors in " + checkResult.getCode(), checkResult.getCode() == 1);
        assertThat("API reported errors in " + checkResult.getMessage(), checkResult.getMessage().equals("Pet not found"));
    }

}
