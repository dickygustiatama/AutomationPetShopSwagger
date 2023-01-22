
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

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class CreateListOfUserWithArrayStepDef {

    @Steps
    UserAPI userAPI;

    @Given("Base URL list of user with valid and complete body")
    public void baseURLListOfUserWithValidAndCompleteBodyJson() {
        File json = new File(Constant.JSON_REQUEST + "/User/PostCreateListOfUserWithArray/PostRequestCreateListOfUserWithArray.json");
        userAPI.postCreateUserWithArray(json);
    }

    @Given("Base URL list of user without id")
    public void baseURLListOfUserWithoutIdJson() {
        File json = new File(Constant.JSON_REQUEST + "/User/PostCreateListOfUserWithArray/PostRequestCreateListOfUserWithArrayWithoutId.json");
        userAPI.postCreateUserWithArray(json);
    }

    @Given("Base URL list of user without username")
    public void baseURLListOfUserWithoutUsernameJson() {
        File json = new File(Constant.JSON_REQUEST + "/User/PostCreateListOfUserWithArray/PostRequestCreateListOfUserWithArrayWithoutUsername.json");
        userAPI.postCreateUserWithArray(json);
    }

    @Given("Base URL list of user without first name")
    public void baseURLListOfUserWithoutFirstnameJson() {
        File json = new File(Constant.JSON_REQUEST + "/User/PostCreateListOfUserWithArray/PostRequestCreateListOfUserWithoutFirstName.json");
        userAPI.postCreateUserWithArray(json);
    }

    @Given("Base URL list of user without last name")
    public void baseURLListOfUserWithoutLastnameJson() {
        File json = new File(Constant.JSON_REQUEST + "/User/PostCreateListOfUserWithArray/PostRequestCreateListOfUserWithArrayWithoutLastName.json");
        userAPI.postCreateUserWithArray(json);
    }

    @Given("Base URL list of user without email")
    public void baseURLListOfUserWithoutEmailJson() {
        File json = new File(Constant.JSON_REQUEST + "/User/PostCreateListOfUserWithArray/PostRequestCreateListOfUserWithArrayWithoutEmail.json");
        userAPI.postCreateUserWithArray(json);
    }

    @Given("Base URL list of user without password")
    public void baseURLListOfUserWithoutPasswordJson() {
        File json = new File(Constant.JSON_REQUEST + "/User/PostCreateListOfUserWithArray/PostRequestCreateListOfUserWithArrayWithoutPassword.json");
        userAPI.postCreateUserWithArray(json);
    }

    @Given("Base URL list of user without phone")
    public void baseURLListOfUserWithoutPhoneJson() {
        File json = new File(Constant.JSON_REQUEST + "/User/PostCreateListOfUserWithArray/PostRequestCreateListOfUserWithArrayWithoutPhone.json");
        userAPI.postCreateUserWithArray(json);
    }

    @Given("Base URL list of user without user status")
    public void baseURLListOfUserWithoutUserStatusJson() {
        File json = new File(Constant.JSON_REQUEST + "/User/PostCreateListOfUserWithArray/PostRequestCreateListOfUserWithArrayWithoutUserStatus.json");
        userAPI.postCreateUserWithArray(json);
    }

    @Given("Base URL list of user with invalid variable")
    public void baseURLListOfUserWithInvalidVariableJson() {
        File json = new File(Constant.JSON_REQUEST + "/User/PostCreateListOfUserWithArray/PostRequestCreateListOfUserWithArrayWithInvalidVariable.json");
        userAPI.postCreateUserWithArray(json);
    }

    @Given("Base URL list of user without body")
    public void baseURLListOfUserWithoutBodyJson() {
        File json = new File(Constant.JSON_REQUEST + "/User/PostCreateListOfUserWithArray/PostRequestCreateListOfUserWithArrayWithoutBody.json");
        userAPI.postCreateUserWithArray(json);
    }

    @When("send request POST list of user with array")
    public void sendRequestPostListOfUserWithArray() {
        SerenityRest.when().post(UserAPI.POST_USER_LIST);
    }


    @Then("validate json schema post create list of user input array")
    public void validateJsonSchemaPostCreateUserInputArray() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/UserSchema/PostCreateListOfUserWithArraySchema.json");;
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

}


