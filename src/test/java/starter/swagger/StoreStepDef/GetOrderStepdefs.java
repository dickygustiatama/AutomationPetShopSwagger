package starter.swagger.StoreStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.swagger.StoreAPI;
import starter.swagger.Utils.Constant;

import java.io.File;

public class GetOrderStepdefs {
    @Steps
    StoreAPI storeAPI;

    @Given("get order with valid id {string}")
    public void getOrderWithId(String id) {
        storeAPI.getOrderId(id);
    }

    @When("Send request get order")
    public void sendRequestGetOrder() {
        SerenityRest.when().get(StoreAPI.GET_ORDER_ID);
    }

    @Then("Should return status get order code {int}")
    public void shouldReturnStatusGetOrderCode(int code) {
        SerenityRest.then().statusCode(code);
    }

    @And("validate response body with json schema")
    public void validateResponseBodyWithJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/StoreSchema/getOrderSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("get order with invalid id {string}")
    public void getOrderWithInvalidId(String id) {
        storeAPI.getOrderId(id);
    }
}
