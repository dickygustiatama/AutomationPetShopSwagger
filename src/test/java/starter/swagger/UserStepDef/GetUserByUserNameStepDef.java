package starter.swagger.UserStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.swagger.PetAPI;
import starter.swagger.UserAPI;
import starter.swagger.Utils.Constant;
import starter.swagger.Utils.SwaggerResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class GetUserByUserNameStepDef {

    @Steps
    UserAPI userAPI;

    @Given("get User with input username {string}")
    public void getUserWithInputUsernameJson(String username) {
        userAPI.getUserFindByUsername(username);
    }

    @Given("get User with input username as email {string}")
    public void getUserWithInputUsernameAsEmail(String username) {
        userAPI.getUserFindByUsername(username);
    }

    @And("Send request get User with input username")
    public void sendRequestGetUserWithInputUsername() {
        SerenityRest.when().get(UserAPI.GET_USER_USERNAME);
    }

    @And("Send request get User with input username as email")
    public void sendRequestGetUserWithInputUsernameAsEmail() {
        SerenityRest.when().get(UserAPI.GET_USER_USERNAME);
    }


    @And("Response body should be the same username as {string}")
    public void responseBodyShouldBeTheSameUsernameAs(String username) {
        SerenityRest.then().body(SwaggerResponses.MESSAGE_GET_USER,equalTo(username));
    }

    @Then("validate json schema get user by valid username")
    public void validateJsonSchemaGetUserByValidUsernameJson() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/UserSchema/GetUserSchema.json");;
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Then("validate json schema get user by invalid username")
    public void validateJsonSchemaGetUserByInvalidUsernameJson() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/UserSchema/GetUserInvalidSchema.json");;
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
