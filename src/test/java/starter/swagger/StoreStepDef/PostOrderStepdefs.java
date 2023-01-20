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

public class PostOrderStepdefs {
    @Steps
    StoreAPI storeAPI;

    @Given("Post create order with valid json {string}")
    public void postCreateOrderWithValidJson(String filename) {
        File json = new File(Constant.JSON_REQUEST + "/store/" + filename);
        storeAPI.createNewOrder(json);
    }

    @When("Send request post create order")
    public void sendRequestPostCreateOrder() {
        SerenityRest.when().post(StoreAPI.POST_STORE_ORDER);
    }

    @Then("Should return status create code {int}")
    public void shouldReturnStatusCreateCode(int code) {
        SerenityRest.then().statusCode(code);
    }

    @And("Response body should be match with json schema")
    public void responseBodyShouldBeMatchWithJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/StoreSchema/storeSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post create order with invalid json {string}")
    public void postCreateUserWithInvalidJson(String filename) {
        File json = new File(Constant.JSON_REQUEST + "/store/" + filename);
        storeAPI.createNewOrder(json);
    }
}
