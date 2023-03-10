package starter.swagger;

import io.cucumber.java.eo.Se;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.swagger.Utils.Constant;

import java.io.File;

public class UserAPI {


    //User
    public static String POST_USER_ARRAY = Constant.BASE_URL + "/user/createWithArray";
    public static String POST_USER_LIST = Constant.BASE_URL + "/user/createWithList";
    public static String GET_USER_USERNAME = Constant.BASE_URL + "/user/{username}";
    public static String PUT_UPDATE_USER = Constant.BASE_URL + "/user/{username}";
    public static String DELETE_USER = Constant.BASE_URL + "/user/{username}";
    public static String GET_USER_LOGIN = Constant.BASE_URL + "/user/login";
    public static String GET_USER_LOGOUT = Constant.BASE_URL + "/user/logout";
    public static String POST_CREATE_USER = Constant.BASE_URL + "/user";

    @Step("Post create a user")
    public void setPostCreateUser(File json) {
        SerenityRest.given()
                    .contentType(ContentType.JSON)
                    .body(json);
    }

    @Step("Delete user")
    public void setDeleteUser(String username){
        SerenityRest.given().pathParam("username",username);
    }

    @Step("Get login user")
    public void setGetUserLogin(File json){
        SerenityRest.given()
                    .contentType(ContentType.JSON)
                    .body(json);
    }

    @Step("Get logout user")
    public void setGetUserLogout(){
        SerenityRest.given();
    }

    @Step("Post create user with array")
    public void postCreateUserWithArray(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Get user find by username")
    public void getUserFindByUsername(String username) {
        SerenityRest.given().pathParam("username", username);
    }

    @Step("Put update user")
    public void putUpdateUser(String username, File json) {
        SerenityRest.given()
                .pathParam("username", username)
                .contentType(ContentType.JSON)
                .body(json);
    }


    @Step("Post create list of user")
    public void postCreateListOfUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

}