package starter.swagger.UserStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.swagger.UserAPI;
import starter.swagger.Utils.Constant;
import starter.swagger.Utils.SwaggerResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class DeleteUserStepDef {
    @Steps
    UserAPI userAPI;
    @Given("Base URL for delete user with valid username {string}")
    public void baseURLForDeleteUserWithValidUsername(String username) {
        userAPI.setDeleteUser(username);
    }

    @When("Send request delete user")
    public void sendRequestDeleteUser() {
        SerenityRest.when().delete(UserAPI.DELETE_USER);
    }

    @And("Response body should be the same as username {string}")
    public void responseBodyShouldBeTheSame(String username) {
        SerenityRest.then().body(SwaggerResponses.MESSAGE,equalTo(username));
    }

    @And("Validate json schema delete user")
    public void validateJsonSchemaDeleteUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/UserSchema/DeleteUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
