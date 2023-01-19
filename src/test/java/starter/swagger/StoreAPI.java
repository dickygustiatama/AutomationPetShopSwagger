package starter.swagger;

import starter.swagger.Utils.Constant;

public class StoreAPI {
    //Store
    public static String POST_STORE_ORDER = Constant.BASE_URL+"/store/order" ;
    public static String GET_ORDER_ID = Constant.BASE_URL+"/store/order/{orderId}";
    public static String DELETE_ORDER_ID = Constant.BASE_URL+"/store/order/{orderId}" ;
    public static String GET_STORE_INVENTORY = Constant.BASE_URL+"/store/inventory" ;

}
