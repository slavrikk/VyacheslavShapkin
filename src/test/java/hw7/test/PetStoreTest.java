package hw7.test;

import hw7.bean.PetBean;
import hw7.bean.ResponseBean;
import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static hw7.core.PetStorePetServiceObj.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class PetStoreTest {

    @Test(priority = 1)
    public void postPetTest() {
        PetBean result = getAnswers(
                requestBuilder()
                        .setName("Doge")
                        .setId(47)
                        .setCategory(42, "funny memes")
                        .setTeg(50, "cute doge")
                        .setUrl("https://upload.wikimedia.org/wikipedia/ru/5/5f/Original_Doge_meme.jpg")
                        .setMethod(Method.POST)
                        .buildRequest()
                        .sendRequest());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(result.getId(), 47);
        softAssert.assertEquals(result.getCategoryBean().getName(), "funny memes");
        softAssert.assertEquals(result.getTags().get(0).getId(), 50);
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void getPetByIdTest() {
        PetBean result = getAnswers(
                requestBuilder()
                        .setMethod(Method.GET)
                        .buildRequest()
                        .sendRequestById("47"));
        Assert.assertEquals(result.getName(), "Doge");
        Assert.assertEquals(result.getPhotoUrls().size(), 1);
    }

    @Test(priority = 3)
    public void changePetNameByIdTest() {
        ResponseBean result = getAnswersStatus(
                requestBuilder()
                        .setMethod(Method.POST)
                        .buildRequest()
                        .sendRequestChangeNamePost("47", "Dogeeee", "nice_doge"));
        assertThat("API reported errors in type text: " + result.getMessage(), result.getMessage().equals("47"));
    }

    @Test(priority = 4)
    public void checkChangePetStatusById() {
        PetBean result = getAnswers(
                requestBuilder()
                        .setMethod(Method.GET)
                        .buildRequest()
                        .sendRequestById("47"));
        assertThat("API reported errors in type text: " + result.getStatus(), result.getStatus().equals("nice_doge"));
    }

    @Test(priority = 4)
    public void deletePet() {
        ResponseBean result = getAnswersStatus(
                requestBuilder()
                        .setMethod(Method.DELETE)
                        .buildRequest()
                        .sendRequestById("47"));
        assertThat("API reported errors in " + result.getCode(), result.getCode() == 200);
    }

    @Test(priority = 5)
    public void checkDeletedPet() {
        ResponseBean result = getAnswersStatus(
                requestBuilder()
                        .setMethod(Method.GET)
                        .buildRequest()
                        .sendRequestById("47"));
        assertThat("API reported errors in " + result.getCode(), result.getCode() == 1);
        assertThat("API reported errors in " + result.getMessage(), result.getMessage().equals("Pet not found"));
    }


}
