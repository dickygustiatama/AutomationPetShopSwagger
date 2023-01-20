package starter.swagger.UserStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.swagger.UserAPI;
import starter.swagger.Utils.Constant;

import java.io.File;

public class LoginUserStepDef {
    @Steps
    UserAPI userAPI;

    @Given("Base URL for Login User with username and password")
    public void baseURLForLoginUserWithUsernameAndPassword() {
        File json = new File(Constant.JSON_REQUEST + "/User/LoginUser/LoginUser.json");
        userAPI.setGetUserLogin(json);
    }

    @When("Send request Login User")
    public void sendRequestLoginUser() {
        SerenityRest.when().get(UserAPI.GET_USER_LOGIN);
    }

    @And("Validate json schema Inventory Status")
    public void validateJsonSchemaInventoryStatus() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/UserSchema/LoginUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));

    }


    @Given("Base URL for Login User with invalid username but valid password")
    public void baseURLForLoginUserWithInvalidUsernameButValidPassword() {
        File json = new File(Constant.JSON_REQUEST + "/User/LoginUser/WithInvalidUsername.json");
        userAPI.setGetUserLogin(json);
    }

    @Given("Base URL for Login User with valid username but invalid password")
    public void baseURLForLoginUserWithValidUsernameButInvalidPassword() {
        File json = new File(Constant.JSON_REQUEST + "/User/LoginUser/WithInvalidPassword.json");
        userAPI.setGetUserLogin(json);
    }

    @Given("Base URL for Login User without body")
    public void baseURLForLoginUserWithoutBody() {
        File json = new File(Constant.JSON_REQUEST + "/User/LoginUser/WithoutBody.json");
        userAPI.setGetUserLogin(json);
    }
}
