package starter.swagger.UserStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.swagger.UserAPI;
import starter.swagger.Utils.Constant;
import starter.swagger.Utils.SwaggerResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CreateAUserStepDef {
    @Steps
    UserAPI userAPI;
    @Given("Base URL for create a user with valid and complete body")
    public void baseURLForCreateAUserWithValidAndCompleteBody() {
        File json = new File(Constant.JSON_REQUEST + "/User/CreateUser/CreateUser.json");
        userAPI.setPostCreateUser(json);
    }

    @When("Send request post create a user")
    public void sendRequestPostCreateAUser() {
        SerenityRest.when().post(UserAPI.POST_CREATE_USER);
    }

    @Then("Should return status code {int}")
    public void shouldReturnStatusCode(int code) {
        SerenityRest.then().statusCode(code);
    }

    @And("Response message body should be the same as {string}")
    public void responseBodyShouldBeTheSame(String id) {
        SerenityRest.then().body(SwaggerResponses.MESSAGE,equalTo(id));
    }

    @And("Validate json schema place an order")
    public void validateJsonSchemaPlaceAnOrder() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/UserSchema/CreateUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Base URL for create a user without id in body")
    public void baseURLForCreateAUserWithoutIdInBody() {
        File json = new File(Constant.JSON_REQUEST + "/User/CreateUser/WithoutId.json");
        userAPI.setPostCreateUser(json);
    }

    @And("Response body id should autogenerated id")
    public void responseBodyIdShouldAutogeneratedId() {
        SerenityRest.then().body(SwaggerResponses.MESSAGE,notNullValue());
    }

    @Given("Base URL for create a user without username in body")
    public void baseURLForCreateAUserWithoutUsernameInBody() {
        File json = new File(Constant.JSON_REQUEST + "/User/CreateUser/WithoutUsername.json");
        userAPI.setPostCreateUser(json);
    }

    @And("Response body message should be {string}")
    public void responseBodyMessageShouldBe(String message) {
        SerenityRest.then().body(SwaggerResponses.MESSAGE,equalTo(message));
    }

    @Given("Base URL for create a user without firstName in body")
    public void baseURLForCreateAUserWithoutFirstNameInBody() {
        File json = new File(Constant.JSON_REQUEST + "/User/CreateUser/WithoutFirstName.json");
        userAPI.setPostCreateUser(json);
    }

    @Given("Base URL for create a user without lastName in body")
    public void baseURLForCreateAUserWithoutLastNameInBody() {
        File json = new File(Constant.JSON_REQUEST + "/User/CreateUser/WithoutLastName.json");
        userAPI.setPostCreateUser(json);
    }

    @Given("Base URL for create a user without email in body")
    public void baseURLForCreateAUserWithoutEmailInBody() {
        File json = new File(Constant.JSON_REQUEST + "/User/CreateUser/WithoutEmail.json");
        userAPI.setPostCreateUser(json);
    }

    @Given("Base URL for create a user without password in body")
    public void baseURLForCreateAUserWithoutPasswordInBody() {
        File json = new File(Constant.JSON_REQUEST + "/User/CreateUser/WithoutPassword.json");
        userAPI.setPostCreateUser(json);
    }

    @Given("Base URL for create a user without phone in body")
    public void baseURLForCreateAUserWithoutPhoneInBody() {
        File json = new File(Constant.JSON_REQUEST + "/User/CreateUser/WithoutPhone.json");
        userAPI.setPostCreateUser(json);
    }

    @Given("Base URL for create a user without userStatus in body")
    public void baseURLForCreateAUserWithoutUserStatusInBody() {
        File json = new File(Constant.JSON_REQUEST + "/User/CreateUser/WithoutUserStatus.json");
        userAPI.setPostCreateUser(json);
    }

    @Given("Base URL for create a user with invalid data type in body")
    public void baseURLForCreateAUserWithInvalidDataTypeInBody() {
        File json = new File(Constant.JSON_REQUEST + "/User/CreateUser/WithInvalidDataType.json");
        userAPI.setPostCreateUser(json);
    }

    @Given("Base URL for create a user without body")
    public void baseURLForCreateAUserWithoutBody() {
        File json = new File(Constant.JSON_REQUEST + "/User/CreateUser/WithoutBody.json");
        userAPI.setPostCreateUser(json);
    }
}
