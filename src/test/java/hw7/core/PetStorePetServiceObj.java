package hw7.core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hw7.bean.CategoryBean;
import hw7.bean.PetBean;
import hw7.bean.ResponseBean;
import hw7.bean.TagBean;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;

import java.lang.reflect.Modifier;
import java.net.URI;

public class PetStorePetServiceObj {

    public static final URI PETSTORE_URI = URI.create("https://petstore.swagger.io/v2/pet/");
    private Method requestMethod;
    private PetBean petBean;


    public PetStorePetServiceObj(Method requestMethod, PetBean petBean) {
        this.requestMethod = requestMethod;
        this.petBean = petBean;

    }

    public static ApiRequestBuilder requestBuilder() {
        return new ApiRequestBuilder();
    }

    public static class ApiRequestBuilder {

        private final PetBean petBean = new PetBean();
        private Method requestMethod = Method.GET;
        private String contentType;

        public ApiRequestBuilder setMethod(Method method) {
            requestMethod = method;
            return this;
        }

        public ApiRequestBuilder setId(int id) {
            petBean.setId(id);
            return this;
        }

        public ApiRequestBuilder setName(String name) {
            petBean.setName(name);
            return this;
        }

        public ApiRequestBuilder setStatus(String status) {
            petBean.setStatus(status);
            return this;
        }

        public ApiRequestBuilder setContentType(String contentType) {
            petBean.setContentType(contentType);
            return this;
        }

        public String getContentType() {
            return contentType;
        }

        public ApiRequestBuilder setCategory(int categoryId, String categoryName) {
            CategoryBean categoryBean = new CategoryBean();
            categoryBean.setId(categoryId);
            categoryBean.setName(categoryName);
            petBean.setCategoryBean(categoryBean);
            return this;
        }

        public ApiRequestBuilder setTeg(int tagId, String tagName) {
            TagBean tagBean = new TagBean();
            tagBean.setId(tagId);
            tagBean.setName(tagName);
            petBean.getTags().add(tagBean);
            return this;
        }

        public ApiRequestBuilder setUrl(String url) {
            petBean.getPhotoUrls().add(url);
            return this;
        }


        public PetStorePetServiceObj buildRequest() {
            return new PetStorePetServiceObj(requestMethod, petBean);
        }
    }

    public io.restassured.response.Response sendRequestById(String id) {
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .request(requestMethod, PETSTORE_URI + id)
                .prettyPeek();
    }


    public io.restassured.response.Response sendRequest() {
      Gson gson = new Gson();
      ContentType contentType;
      String body;
      String id = "";
        if(petBean.getContentType().equals("URLENC")){
            contentType =  ContentType.URLENC;
            body = "name=" + petBean.getName() + "&" + "status=" + petBean.getStatus();
            id = String.valueOf(petBean.getId());
        }
        else {
            contentType = ContentType.JSON;
            body = gson.toJson(petBean);
        }
        return RestAssured
                .given().log().all()
                .contentType(contentType)
                .body(body)
                .request(requestMethod, PETSTORE_URI+id)
                .prettyPeek();
    }


    public static PetBean getAnswers(io.restassured.response.Response response) {
        return new Gson()
                .fromJson(response.asString().trim(), PetBean.class);
    }

    public static ResponseBean getAnswersStatus(io.restassured.response.Response response) {
        ResponseBean answers = new Gson()
                .fromJson(response.asString().trim(), ResponseBean.class);
        return answers;
    }

}
