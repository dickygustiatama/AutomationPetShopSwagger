package starter.swagger.UserStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import starter.swagger.UserAPI;
import starter.swagger.Utils.Constant;

import java.io.File;

public class LogoutUserStepDef {
    @Steps
    UserAPI userAPI;
    @Given("Base URL for Logout")
    public void baseURLForLogout() {
        userAPI.setGetUserLogout();
    }

    @When("Send request Logout without parameter")
    public void sendRequestLogoutWithoutParameter() {
        SerenityRest.when().get(UserAPI.GET_USER_LOGOUT);
    }

    @And("Validate json schema Logout")
    public void validateJsonSchemaLogout() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/UserSchema/LogoutUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
