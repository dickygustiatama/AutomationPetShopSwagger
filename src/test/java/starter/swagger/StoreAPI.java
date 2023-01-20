package starter.swagger;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.swagger.Utils.Constant;

import java.io.File;

public class StoreAPI {
    //Store
    public static String POST_STORE_ORDER = Constant.BASE_URL+"/store/order" ;
    public static String GET_ORDER_ID = Constant.BASE_URL+"/store/order/{orderId}";
    public static String DELETE_ORDER_ID = Constant.BASE_URL+"/store/order/{orderId}" ;
    public static String GET_STORE_INVENTORY = Constant.BASE_URL+"/store/inventory" ;

    @Step("Get order by id")
    public void getOrderId(String id) {
        SerenityRest.given().pathParam("orderId", id);
    }

    @Step("Create new order")
    public void createNewOrder(File json) {
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

    @Step("Delete order by id")
    public void deleteOrderId(String id) {SerenityRest.given().pathParam("orderId", id);}
}
