package starter.swagger.StoreStepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.swagger.StoreAPI;

public class DeleteOrderStepdefs {
    @Steps
    StoreAPI storeAPI;

    @Given("delete order with valid id {string}")
    public void deleteOrder(String id) {
        storeAPI.deleteOrderId(id);
    }

    @When("Send request delete order")
    public void sendRequestDeleteOrder() {
        SerenityRest.when().delete(StoreAPI.DELETE_ORDER_ID);
    }

    @Then("Should return status delete order code {int}")
    public void shouldReturnStatusDeleteOrderCode(int code) {
        SerenityRest.then().statusCode(code);
    }

    @Given("delete order with invalid id {string}")
    public void deleteOrderWithInvalidId(String id) {
        storeAPI.deleteOrderId(id);
    }
}
