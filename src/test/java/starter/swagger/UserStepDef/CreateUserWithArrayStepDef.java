package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.swagger.UserAPI;
import starter.swagger.Utils.Constant;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class CreateUserWithArrayStepDef {

    @Steps
    UserAPI userAPI;

    @Given("Base URL with valid and complete body")
    public void baseURLWithValidAndCompleteBodyJson() {
        File json = new File(Constant.JSON_REQUEST + "/User/PostCreateUserWithArray/PostRequestCreateUserWithArray.json");
        userAPI.postCreateUserWithArray(json);
    }

    @Given("Base URL without id")
    public void baseURLWithoutIdJson() {
        File json = new File(Constant.JSON_REQUEST + "/User/PostCreateUserWithArray/PostRequestCreateUserWithArrayWithoutId.json");
        userAPI.postCreateUserWithArray(json);
    }

    @Given("Base URL without username")
    public void baseURLWithoutUsernameJson() {
        File json = new File(Constant.JSON_REQUEST + "/User/PostCreateUserWithArray/PostRequestCreateUserWithArrayWithoutUsername.json");
        userAPI.postCreateUserWithArray(json);
    }

    @Given("Base URL without first name")
    public void baseURLWithoutFirstnameJson() {
        File json = new File(Constant.JSON_REQUEST + "/User/PostCreateUserWithArray/PostRequestCreateUserWithoutFirstName.json");
        userAPI.postCreateUserWithArray(json);
    }

    @Given("Base URL without last name")
    public void baseURLWithoutLastnameJson() {
        File json = new File(Constant.JSON_REQUEST + "/User/PostCreateUserWithArray/PostRequestCreateUserWithArrayWithoutLastName.json");
        userAPI.postCreateUserWithArray(json);
    }

    @Given("Base URL without email")
    public void baseURLWithoutEmailJson() {
        File json = new File(Constant.JSON_REQUEST + "/User/PostCreateUserWithArray/PostRequestCreateUserWithArrayWithoutEmail.json");
        userAPI.postCreateUserWithArray(json);
    }

    @Given("Base URL without password")
    public void baseURLWithoutPasswordJson() {
        File json = new File(Constant.JSON_REQUEST + "/User/PostCreateUserWithArray/PostRequestCreateUserWithArrayWithoutPassword.json");
        userAPI.postCreateUserWithArray(json);
    }

    @Given("Base URL without phone")
    public void baseURLWithoutPhoneJson() {
        File json = new File(Constant.JSON_REQUEST + "/User/PostCreateUserWithArray/PostRequestCreateUserWithArrayWithoutPhone.json");
        userAPI.postCreateUserWithArray(json);
    }

    @Given("Base URL without user status")
    public void baseURLWithoutUserStatusJson() {
        File json = new File(Constant.JSON_REQUEST + "/User/PostCreateUserWithArray/PostRequestCreateUserWithArrayWithoutUserStatus.json");
        userAPI.postCreateUserWithArray(json);
    }

    @Given("Base URL with invalid variable")
    public void baseURLWithInvalidVariableJson() {
        File json = new File(Constant.JSON_REQUEST + "/User/PostCreateUserWithArray/PostRequestCreateUserWithArrayWithInvalidVariable.json");
        userAPI.postCreateUserWithArray(json);
    }

    @Given("Base URL without body")
    public void baseURLWithoutBodyJson() {
        File json = new File(Constant.JSON_REQUEST + "/User/PostCreateUserWithArray/PostRequestCreateUserWithArrayWithoutBody.json");
        userAPI.postCreateUserWithArray(json);
    }

    @When("send request POST user with array")
    public void sendRequestPostUserWithArray() {
        SerenityRest.when().post(UserAPI.POST_USER_ARRAY);
    }


    @And("response body have message {string}")
    public void responseBodyHaveMessage(String message) {
        SerenityRest.then()
                .body("message", equalTo(message));
    }

    @Then("validate json schema post create user input array")
    public void validateJsonSchemaPostCreateUserInputArray() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/UserSchema/PostCreateUserWithArraySchema.json");;
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

}
