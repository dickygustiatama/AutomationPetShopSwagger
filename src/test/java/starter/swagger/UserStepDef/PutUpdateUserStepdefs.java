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

public class PutUpdateUserStepdefs {

    @Steps
    UserAPI userAPI;

    @Given("put update user with valid username {string}")
    public void putUpdateUserWithValidUsername(String username) {
        File json = new File(Constant.JSON_REQUEST + "/User/PutUpdateUser/PutUpdateUser.json");
        userAPI.putUpdateUser(username, json);
    }

    @Given("put update user with invalid username {string}")
    public void putUpdateUserWithInvalidUsername(String username) {
        File json = new File(Constant.JSON_REQUEST + "/User/PutUpdateUser/PutUpdateInvalidUser.json");
        userAPI.putUpdateUser(username, json);
    }

    @When("Send request put update user")
    public void sendRequestPutUpdateUSer() {
        SerenityRest.when().put(UserAPI.PUT_UPDATE_USER);
    }

    @And("Validate json schema put update user")
    public void validateJsonSchemaPutUpdateUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/UserSchema/PutUpdateUSerSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
