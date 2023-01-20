package starter.swagger.StoreStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.swagger.StoreAPI;
import starter.swagger.Utils.Constant;

import java.io.File;

public class GetInventoryStepdefs {
    @Steps
    StoreAPI storeAPI;

    @When("Send request get store inventory")
    public void getStoreInventory() {
        SerenityRest.when().get(StoreAPI.GET_STORE_INVENTORY);
    }

    @Then("Should return status get inventory code {int}")
    public void shouldReturnStatusGetInventoryCode(int code) {
        SerenityRest.then().statusCode(code);
    }

    @And("Validate response body with json schema")
    public void validateResponseBodyWithJsonSchema() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/StoreSchema/getInventorySchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
