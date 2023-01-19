package starter.swagger;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.swagger.Utils.Constant;

import java.io.File;

public class PetAPI {
    //Pet
    public static String POST_IMAGE_PET = Constant.BASE_URL+"/pet/{petId}/uploadImage" ;
    public static String POST_NEW_PET = Constant.BASE_URL +"/pet" ;
    public static String PUT_UPDATE_PET = Constant.BASE_URL+"/pet";
    public static String GET_PET_STATUS = Constant.BASE_URL+"/pet/findByStatus";
    public static String GET_PET_ID = Constant.BASE_URL+"/pet/{petId}";
    public static String POST_UPDATE_PET = Constant.BASE_URL+"/pet/{petId}" ;
    public static String DELETE_PET_ID = Constant.BASE_URL+"/pet/{petId}" ;

    @Step("Post new pet")
    public void postNewPet(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step("Post update pet with form data")
    public void setPostUpdatePet(String petId, String name, String status){
        SerenityRest.given()
                    .pathParam("petId",petId)
                    .contentType(ContentType.URLENC)
                    .formParam("name",name)
                    .formParam("status",status);
    }

    @Step("Post upload an image")
    public void setPostImagePet(String petId,String metadata,File image){
        SerenityRest.given()
                    .pathParam("petId",petId)
                    .contentType("multipart/form-data")
                    .multiPart("additionalMetadata",metadata)
                    .multiPart("file",image);
    }

    @Step("Post upload an image without file")
    public void setPostImagePetWithoutFile(String petId,String metadata){
        SerenityRest.given()
                .pathParam("petId",petId)
                .contentType("multipart/form-data")
                .multiPart("additionalMetadata",metadata);
    }

}
