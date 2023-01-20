package starter.swagger;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.swagger.Utils.Constant;
import starter.swagger.Utils.SwaggerResponses;

import java.io.File;

public class PetAPI {
    //Pet
    public static String POST_IMAGE_PET = Constant.BASE_URL+"/pet/{petId}/uploadImage" ;
    public static String POST_NEW_PET = Constant.BASE_URL +"/pet" ;
    public static String PUT_UPDATE_PET = Constant.BASE_URL+"/pet";
    public static String GET_PET_STATUS = Constant.BASE_URL+"/pet/findByStatus?status={status}";
    public static String GET_PET_ID = Constant.BASE_URL+"/pet/{id}";
    public static String GET_PET_NULL_ID = Constant.BASE_URL+"/pet/";
    public static String POST_UPDATE_PET = Constant.BASE_URL+"/pet/{id}" ;
    public static String DELETE_PET_ID = Constant.BASE_URL+"/pet/{id}" ;

    @Step("Post new pet")
    public void postNewPet(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("Get pet by id")
    public void getPetID(int id){
        SerenityRest.given().pathParams(SwaggerResponses.PET_ID,id);
    }

    @Step("Get pet by status")
    public void getPetStatus(String status){
        SerenityRest.given().pathParams(SwaggerResponses.PET_STATUS,status) ;
    }
    @Step("Get pet by invalid id string")
    public void getPetInvalidID(String id){
        SerenityRest.given().pathParams(SwaggerResponses.PET_ID,id);
    }

    @Step("Put update pet by id")
    public void putUpdatePet(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }
    @Step("delete pet")
    public void deletePet(int id){
        SerenityRest.given().pathParams(SwaggerResponses.PET_ID,id) ;
    }
    @Step("delete pet invalid id")
    public void deletePetInvalid(String id){
        SerenityRest.given().pathParams(SwaggerResponses.PET_ID,id) ;
    }

    @Step("Post update pet with form data")
    public void setPostUpdatePet(String id, String name, String status){
        SerenityRest.given().
                pathParams("id",id)
                .contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("name",name)
                .formParam("status",status);
    }
}
