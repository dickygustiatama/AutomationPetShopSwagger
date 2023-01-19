package starter.swagger;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.swagger.Utils.Constant;

import java.io.File;

public class UserAPI {


    //User
    public static String POST_USER_ARRAY = Constant.BASE_URL+"/user/createWithArray" ;
    public static String POST_USER_LIST = Constant.BASE_URL+"/user/createWithList";
    public static String GET_USER_USERNAME = Constant.BASE_URL+"/user/{username}" ;
    public static String PUT_UPDATE_USER = Constant.BASE_URL+"/user/{username}";
    public static String DELETE_USER = Constant.BASE_URL+"/user/{username}" ;
    public static String GET_USER_LOGIN = Constant.BASE_URL+"/user/login" ;
    public static String GET_USER_LOGOUT = Constant.BASE_URL+"/user/logout" ;
    public static String POST_CREATE_USER = Constant.BASE_URL+"/user" ;



}
